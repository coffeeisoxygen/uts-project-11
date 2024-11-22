package com.twentyforseven.model.commands;

import java.beans.PropertyChangeListener;

public interface ICommandHandler {
    void processCommands(String commands);

    void addPropertyChangeListener(PropertyChangeListener listener);
}