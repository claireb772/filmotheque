package fr.eni.filmotheque.services;

import java.util.List;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantService {

	public List<Participant> getListacteurs();

	public Participant getParticipantByID(long id);

}
