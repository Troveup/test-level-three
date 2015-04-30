package com.troveup.test.models;

import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://en.wikipedia.org/wiki/Plain_Old_Java_Object">POJO</a> model for storing Item data.
 */
public class Item
{
    //Enum for narrowing our item categories
    public enum ITEM_TYPE {
        ALL("all"),
        JEWELRY("jewelry"),
        SHOES("shoes"),
        CLOTHING("clothing");

        private final String text;

        ITEM_TYPE(String type) {
            this.text = type;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    //Fields
    private String imageUrl;
    private String itemDescription;

    //Constructors
    public Item(){

    }

    public Item(String imageUrl, String itemDescription)
    {
        this.imageUrl = imageUrl;
        this.itemDescription = itemDescription;
    }

    //Getters and Setters
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * Item method for obtaining an Item Builder object for putting together a List of Items.
     *
     * @param env Environment object from the calling ApplicationContext so that properties may be retrieved from
     *            application.properties
     * @return Builder object for building the List of Items.
     */
    public static Builder getBuilder(Environment env)
    {
        return new Builder(env);
    }

    /**
     * Item method for obtaining an Item Builder object for putting together a List of Items.
     *
     * @param builderType Type of items to be built.  All, Clothing, Shoes, or Jewelry.
     * @param env Environment object from the calling ApplicationContext so that properties may be retrieved from
     *            application.properties
     * @return Builder object for building the List of Items.
     */
    public static Builder getBuilder(ITEM_TYPE builderType, Environment env)
    {
        return new Builder(builderType, env);
    }

    /**
     * Item Builder for conveniently populating a List of Items for the user based on the category.  Contains
     * functionality to, by default, retrieve 9 items based on category from the
     * com/troveup/test/config/properties/application.properties file and populate a List of Items
     */
    public static class Builder
    {
        //Environment field for retrieving data from com/troveup/test/config/properties/application.properties file
        private Environment env;

        //Maximum number of items specified per category in the
        // com/troveup/test/config/properties/application.properties file
        private final int BUILDER_MAX_ITEMS = 9;

        //Type of items that need to be built.  All, Clothing, Shoes, or Jewelry.  Used to determine the properties
        //that are pulled from the com/troveup/test/config/properties/application.properties file
        private ITEM_TYPE builderType;

        //Getters and setters
        public Builder(Environment env)
        {
            this.env = env;
        }

        public Builder(ITEM_TYPE builderType, Environment env)
        {
            this.builderType = builderType;
            this.env = env;
        }

        public ITEM_TYPE getBuilderType() {
            return builderType;
        }

        public Builder builderType(ITEM_TYPE builderType) {
            this.builderType = builderType;

            return this;
        }

        /**
         * Builds a List of prepopulated Items using the BUILDER_MAX_ITEMS field as the maximum number of items to
         * populate.  Will use the env field to retrieve properties found in the
         * com/troveup/test/config/properties/application.properties file, and the builderType field to specify the
         * category of data to pull from the properties file.
         *
         * @return Populated List of Items
         */
        public List<Item> buildItemList()
        {
            List<Item> rval = new ArrayList<>();

            for (int i = 0; i < BUILDER_MAX_ITEMS; ++i)
            {
                //Create the property keys found in the application.properties file
                String imageUrlResource = builderType.toString() + "." + "item" + i + "ImageUrl";
                String itemDescriptionResource = builderType.toString() + "." + "item" + i + "Description";

                //Get the actual property values and create the item using them
                Item item = new Item(env.getProperty(imageUrlResource), env.getProperty(itemDescriptionResource));

                //Add it to the list
                rval.add(item);
            }

            return rval;
        }

    }
}
