package fr.eni.filmotheque.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Participant;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	private List<Participant> listParticipants;
	private Map<Integer, Participant> mapParticipants;

	public ParticipantServiceImpl() {
		listParticipants = new ArrayList<>();
		listParticipants.add(new Participant("Pitt", "Brad"));
		listParticipants.add(new Participant("Norton", "Edward"));

		mapParticipants = new HashMap<Integer, Participant>();
		listParticipants.forEach(m -> mapParticipants.put((int) m.getId(), m));

	}

	@Override
	public List<Participant> getListParticipant() {
		return listParticipants;
	}

	@Override
	public Map<Integer, Participant> getMapParticipants() {

		return mapParticipants;
	}

}
