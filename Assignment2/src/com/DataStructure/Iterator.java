package com.DataStructure;

import nullObject.Node;

public interface Iterator {
   boolean hasNext();
   Node next();
   Node getCurrentElement();
}
