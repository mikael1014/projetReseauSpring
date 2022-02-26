package org.mn.projetreseauspringfront.service;

import java.util.Collection;
import java.util.List;

import org.mn.projetreseauspringfront.dto.MessageDTO;


public interface MessageService {
	Collection<MessageDTO> findAllRecentMessages(Long id);

    List<MessageDTO> findConversation(Long userId, Long companionId);

    MessageDTO getRecentMessage(Long id);

    void postMessage(MessageDTO messageDTO);
}
