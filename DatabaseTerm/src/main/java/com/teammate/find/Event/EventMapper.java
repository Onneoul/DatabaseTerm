package com.teammate.find.Event;

import java.util.List;

public interface EventMapper {
	public abstract List<Event> viewEvent(EventSelector eS);
	public abstract List<Event> viewEvent1(EventSelector eS);
	public abstract Event viewEventDetail(Event e);
	public abstract int getEventCount(EventSelector eS);
	
	public abstract int createEvent(Event e);
	public abstract int updateEvent(Event e);
	public abstract int deleteEvent(Event e);
}
