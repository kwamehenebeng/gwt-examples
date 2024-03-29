package org.gonevertical.loc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/*
 * TODO
 * 
 * DONE Fix Timer 7 
 * DONE Fix Digits 5
 * DONE After winner, make start start it again
 * 
 * 
 * - make button elements to represent there on and off lights
 * 
 * - Add Winner Event To Player A and Player B items
 * 
 * - add init to the dmx, turn on starting lights, switches, and paddles, score? this may happen on repeat
 * 
 * - init paddles after all/on off, then start
 * 
 * 
 * 
 */



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LightsForChristmas implements EntryPoint, NativePreviewHandler, ValueChangeHandler<String> {

  private VerticalPanel pWidget = new VerticalPanel();
  
  private SnowBallGameFrame wframe = new SnowBallGameFrame();

  public void onModuleLoad() {
  	
  	initHistoryObservation();
    
    pWidget.add(wframe);

    RootPanel.get("content").add(pWidget);

    pWidget.setWidth("100%");
    pWidget.setCellHorizontalAlignment(wframe, HorizontalPanel.ALIGN_CENTER);
    
    Event.addNativePreviewHandler(this);
    
  }

  /**
   * intercept all the events of the DOM
   */
  public void onPreviewNativeEvent(NativePreviewEvent event) {

    NativeEvent e = event.getNativeEvent();
    int type = Event.getTypeInt(e.getType());
    Event ev = Event.as(e);
    int keyCode = ev.getKeyCode();
    
    // Debugging
    //System.out.println("keyCode:" + keyCode + " TypeString:" + e.getType());
    
    if (type == Event.ONKEYPRESS) {
      wframe.move(keyCode);
    }
  }


  private void initHistoryObservation() {
  	History.addValueChangeHandler(this);
  }

  public void onValueChange(ValueChangeEvent<String> event) {
	 
  	// get the querystring token
  	String historyToken = History.getToken();
  	
  	// send to static method that will send the __utm.gif to google's server fro tracking
  	Track.track(historyToken);
	  
  }

  
}

