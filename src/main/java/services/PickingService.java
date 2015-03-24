package services;

import forms.PickingForm;
import jpa.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.utils.picking.*;

@Service
public class PickingService {

    @Autowired
    private ContainerAllocator containerAllocator;
    @Autowired
    private NextPickingFinder nextPickingFinder;
    @Autowired
    private PickingProcessor pickingProcessor;
    @Autowired
    private ContainerFinisher containerFinisher;

    public Container assignContainer(String username) {

        return containerAllocator.allocate(username);
    }

    public PickingForm getNextPicking(Container container) throws PickingNotFoundException {

        return nextPickingFinder.find(container);
    }

    public void processPicking(PickingForm pickingForm, Container container) {

        pickingProcessor.process(pickingForm, container);
    }

    public void finishContainer(Container container) throws NotValidOutgoingDockException {

        containerFinisher.finish(container);
    }

}
