# GUI - Basic widgets

## The View class

![view_class](view_class.png)

- The View class is the Android’s most basic component from which user interfaces can be created. It acts as a container of displayable elements
- A View occupies a rectangular area on the screen and is responsible for drawing and event handling 
- Widgets are subclasses of View. They are used to create interactive UI components such as buttons, checkboxes, labels, text fields, etc. 
- Layouts are invisible structured containers used for holding other Views and nested layouts. 

### Nesting XML Layouts

- An Android’s XML view file consists of a layout design holding a hierarchical arrangement of its contained elements 
- The  inner elements could be basic widgets or user-defined nested layouts holding their own viewgroups
- An Activity uses the `setContentView(R.layout.xmlfilename)` method to render a  view on the device’s screen

### Setting Views to Work

Dealing with widgets & layouts typically involves the following operations

- Set properties:  For instance, when working with a TextView you set the background color, text, font, alignment,  size, padding,  marging, etc.
- Set up listeners: For example, an image could be programmed to respond to various events such as: click, long-tap, mouseover, etc.

