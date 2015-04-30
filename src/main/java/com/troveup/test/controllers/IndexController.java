package com.troveup.test.controllers;

import com.troveup.test.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Index controller, responsible for the business logic behind the various views.
 */
@Controller
public class IndexController {

    //Make sure we have a pointer to the application's context.  This way we can grab the Environment object
    //for the Item Builder
    @Autowired
    ApplicationContext ctx;

    /**
     * Default controller for the "/" GET request URL.  Retrieves a list of 9 "All" category items and places them
     * in the model under the "items" key for retrieval.  Additionally, will check for the "X-PJAX" header, and
     * either return the "all.jsp" view directly, or return the "fullpageloader.jsp" view with an additional key
     * "pageToLoad" containing the jsp page name "all.jsp" for loading at the view level.  Will also include the
     * "pageTitle" key with the page title specified.
     *
     * @param pjaxHeader The value of the request header "X-PJAX", passed by a PJAX request
     * @return ModelAndView object containing all necessary business logic data for view implementation
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView all(@RequestHeader(required = false, value="X-PJAX") String pjaxHeader)
    {
        ModelAndView rval = new ModelAndView();

        //Build the list of items and add them to the model
        List<Item> items = Item.getBuilder(Item.ITEM_TYPE.ALL, ctx.getEnvironment()).buildItemList();
        rval.addObject("items", items);

        //Add the page title
        rval.addObject("pageTitle", "All");

        //If this is a PJAX request, process and send "all.jsp"
        if (pjaxHeader != null)
            rval.setViewName("all");
        //Otherwise, process and send the "fullpageloader.jsp" view with the "pageToLoad" object within the model
        //specifying the view for the page loader to load.
        else {
            rval.setViewName("fullpageloader");
            rval.addObject("pageToLoad", "all.jsp");
        }

        return rval;
    }

    /**
     * Controller for the "/jewelry" GET request URL.  Retrieves a list of 9 "Jewelry" category items and places
     * them in the model under the "items" key for retrieval.  Additionally, will check for the "X-PJAX" header, and
     * either return the "jewelry.jsp" view directly, or return the "fullpageloader.jsp" view with an additional key
     * "pageToLoad" containing the jsp page name "jewelry.jsp" for loading at the view level.  Will also include the
     * "pageTitle" key with the page title specified.
     *
     * @param pjaxHeader The value of the request header "X-PJAX", passed by a PJAX request
     * @return ModelAndView object containing all necessary business logic data for view implementation
     */
    @RequestMapping(value = "/jewelry", method = {RequestMethod.GET})
    public ModelAndView jewelry(@RequestHeader(required = false, value="X-PJAX") String pjaxHeader)
    {
        ModelAndView rval = new ModelAndView();

        //Build the list of items and add them to the model
        List<Item> items = Item.getBuilder(Item.ITEM_TYPE.JEWELRY, ctx.getEnvironment()).buildItemList();
        rval.addObject("items", items);

        //Add the page title
        rval.addObject("pageTitle", "Jewelry");

        //If this is a PJAX request, process and send "jewelry.jsp"
        if (pjaxHeader != null)
            rval.setViewName("jewelry");
        //Otherwise, process and send the "fullpageloader.jsp" view with the "pageToLoad" object within the model
        //specifying the view for the page loader to load.
        else {
            rval.setViewName("fullpageloader");
            rval.addObject("pageToLoad", "jewelry.jsp");
        }

        return rval;
    }

    /**
     * Controller for the "/shoes" GET request URL.  Retrieves a list of 9 "Shoes" category items and places
     * them in the model under the "items" key for retrieval.  Additionally, will check for the "X-PJAX" header, and
     * either return the "shoes.jsp" view directly, or return the "fullpageloader.jsp" view with an additional key
     * "pageToLoad" containing the jsp page name "shoes.jsp" for loading at the view level.  Will also include the
     * "pageTitle" key with the page title specified.
     *
     * @param pjaxHeader The value of the request header "X-PJAX", passed by a PJAX request
     * @return ModelAndView object containing all necessary business logic data for view implementation
     */
    @RequestMapping(value = "/shoes", method = {RequestMethod.GET})
    public ModelAndView shoes(@RequestHeader(required = false, value="X-PJAX") String pjaxHeader)
    {
        ModelAndView rval = new ModelAndView();

        //Build the list of items and add them to the model
        List<Item> items = Item.getBuilder(Item.ITEM_TYPE.SHOES, ctx.getEnvironment()).buildItemList();
        rval.addObject("items", items);

        //Add the page title
        rval.addObject("pageTitle", "Shoes");

        //If this is a PJAX request, process and send "shoes.jsp"
        if (pjaxHeader != null)
            rval.setViewName("shoes");
        //Otherwise, process and send the "fullpageloader.jsp" view with the "pageToLoad" object within the model
        //specifying the view for the page loader to load.
        else {
            rval.setViewName("fullpageloader");
            rval.addObject("pageToLoad", "shoes.jsp");
        }

        return rval;
    }

    /**
     * Controller for the "/clothing" GET request URL.  Retrieves a list of 9 "Clothing" category items and places
     * them in the model under the "items" key for retrieval.  Additionally, will check for the "X-PJAX" header, and
     * either return the "clothing.jsp" view directly, or return the "fullpageloader.jsp" view with an additional key
     * "pageToLoad" containing the jsp page name "clothing.jsp" for loading at the view level.  Will also include the
     * "pageTitle" key with the page title specified.
     *
     * @param pjaxHeader The value of the request header "X-PJAX", passed by a PJAX request
     * @return ModelAndView object containing all necessary business logic data for view implementation
     */
    @RequestMapping(value = "/clothing", method = {RequestMethod.GET})
    public ModelAndView clothing(@RequestHeader(required = false, value="X-PJAX") String pjaxHeader)
    {
        ModelAndView rval = new ModelAndView();

        //Build the list of items and add them to the model
        List<Item> items = Item.getBuilder(Item.ITEM_TYPE.CLOTHING, ctx.getEnvironment()).buildItemList();
        rval.addObject("items", items);

        //Add the page title
        rval.addObject("pageTitle", "Clothing");

        //If this is a PJAX request, process and send "clothing.jsp"
        if (pjaxHeader != null)
            rval.setViewName("clothing");
        //Otherwise, process and send the "fullpageloader.jsp" view with the "pageToLoad" object within the model
        //specifying the view for the page loader to load.
        else {
            rval.setViewName("fullpageloader");
            rval.addObject("pageToLoad", "clothing.jsp");
        }

        return rval;
    }

    /**
     * Controller responsible for handling AJAX requests for additional card data.  Will simply return an additional
     * set of card data, similar to what was originally passed, so that the view can be populated with more cards.
     *
     * @param cardtype Type of card to request.  Can be any of, "all", "clothing", "jewelry", or "shoes".
     * @return JSON response with a list of 9 Items.
     */
    @RequestMapping(value = "/cards/{cardtype}", method = {RequestMethod.GET}, headers="Accept=application/json")
    @ResponseBody
    public List<Item> getAdditionalCards(@PathVariable("cardtype") String cardtype)
    {
        Item.ITEM_TYPE cardRequestType;

        //Determine the request type
        if (cardtype.equals(Item.ITEM_TYPE.ALL.toString()))
            cardRequestType = Item.ITEM_TYPE.ALL;
        else if (cardtype.equals(Item.ITEM_TYPE.CLOTHING.toString()))
            cardRequestType = Item.ITEM_TYPE.CLOTHING;
        else if (cardtype.equals(Item.ITEM_TYPE.JEWELRY.toString()))
            cardRequestType = Item.ITEM_TYPE.JEWELRY;
        else
            cardRequestType = Item.ITEM_TYPE.SHOES;

        //Build the cards and return them
        List<Item> items = Item.getBuilder(cardRequestType, ctx.getEnvironment()).buildItemList();

        return items;
    }
}
