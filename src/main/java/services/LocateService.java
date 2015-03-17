package services;

import forms.LocateActionForm;
import jpa.LocateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import services.utils.locate.LocateActionAllocator;
import services.utils.locate.LocateActionFinisher;
import services.utils.locate.LocateFormCreator;
import services.utils.locate.LocateFormValidator;

@Service
public class LocateService {

    @Autowired
    private LocateActionAllocator locateActionAllocator;
    @Autowired
    private LocateFormCreator locateFormCreator;
    @Autowired
    private LocateFormValidator locateFormValidator;
    @Autowired
    private LocateActionFinisher locateActionFinisher;

    public LocateActionForm assignLocateAction(String username) {

        LocateAction locateAction = locateActionAllocator.allocate(username);

        return locateFormCreator.create(locateAction);
    }

    public void validate(LocateActionForm locateActionForm, BindingResult bindingResult) {

        locateFormValidator.validate(locateActionForm, bindingResult);
    }

    public void confirmLocate(LocateActionForm locateActionForm) {

        locateActionFinisher.finish(locateActionForm);
    }
}
