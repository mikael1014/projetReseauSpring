package org.mn.projetreseauspringfront.service;

import java.util.Collection;
import java.util.List;

import org.mn.projetreseauspringfront.dto.MessageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class MessageServiceImpl implements MessageService {
	private final RestTemplate restTemplate = new RestTemplate();
	private final String URL_UTILISATEUR = "http://localhost:8080/api/secured/message";
	@Override
	public Collection<MessageDTO> findAllRecentMessages(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageDTO> findConversation(Long userId, Long companionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageDTO getRecentMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postMessage(MessageDTO messageDTO) {
		// TODO Auto-generated method stub

	}

}
