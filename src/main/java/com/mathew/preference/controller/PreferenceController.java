package com.mathew.preference.controller;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.constants.MainConstants;
import com.mathew.controller.base.BaseController;
import com.mathew.controller.util.SessionUtil;
import com.mathew.model.User;
import com.mathew.preference.constants.ConstantsPreference;
import com.mathew.preference.model.Preference;
import com.mathew.service.base.BaseService;
@Controller
public class PreferenceController extends BaseController {

    @Autowired
    private BaseService<Preference> preferenceService;

    @RequestMapping(value = "/preference", method = RequestMethod.GET)
    public ModelAndView preferenceView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = SessionUtil.getCurrentUser();
        String preferenceId = user.getPreferenceId();
        Preference preference = preferenceService.FindOne(preferenceId);
        modelAndView.addObject(ConstantsPreference.PREFERENCE, preference);
        modelAndView.setViewName("/preference/preference");

        return modelAndView;
    }

    @RequestMapping(value = "/preference", method = RequestMethod.POST)
    public String preferenceSave(Preference preference) {
        User user = SessionUtil.getCurrentUser();
        String preferenceId = user.getPreferenceId();
        Query<Preference> query = preferenceService.createQuery();
        query.criteria(MainConstants.ID_DB).equal(preferenceId);

        UpdateOperations<Preference> update = preferenceService.createUpdateOperations();

        update.addToSet(ConstantsPreference.LOGO, preference.getLogo());
        update.addToSet(ConstantsPreference.BACKGROUND_IMAGE, preference.getBackgroundImage());
        update.addToSet(ConstantsPreference.WELCOME_MESSAGE, preference.getWelcomeMessage());

        preferenceService.updateFirst(query, update);
        session.setAttribute(ConstantsPreference.PREFERENCE, preference);

        return MainConstants.REDIRECT_HOME;
    }
}
