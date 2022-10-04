package fr.eni.filmotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.ParticipantRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	private ParticipantRepository participantRepository;

	public ParticipantServiceImpl(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;

	}

	@Override
	public List<Participant> getListacteurs() {
		return participantRepository.findAll();
	}

	@Override
	public Participant getParticipantByID(long id) {
		return participantRepository.findById(id).get();
	}

}
