package fr.eni.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.services.ParticipantService;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {

	private ParticipantService participantService;

	@Autowired
	public StringToParticipantConverter(ParticipantService participantService) {
		this.participantService = participantService;
	}

	@Override
	public Participant convert(String id) {
		Integer participantId = Integer.parseInt(id);
		return participantService.getMapParticipants().get(participantId);
	}

}
