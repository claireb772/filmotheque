package fr.eni.filmotheque.services;

import java.util.List;
import java.util.Map;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantService {

	List<Participant> getListParticipant();

	public Map<Integer, Participant> getMapParticipants();

}
