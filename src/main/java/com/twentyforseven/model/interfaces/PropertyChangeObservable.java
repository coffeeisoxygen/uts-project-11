package com.twentyforseven.model.interfaces;

import java.beans.PropertyChangeListener;

public interface PropertyChangeObservable {
    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}