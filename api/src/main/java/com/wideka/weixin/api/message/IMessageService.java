package com.wideka.weixin.api.message;

import com.wideka.weixin.api.message.bo.File;
import com.wideka.weixin.api.message.bo.Image;
import com.wideka.weixin.api.message.bo.MPNews;
import com.wideka.weixin.api.message.bo.News;
import com.wideka.weixin.api.message.bo.SendResult;
import com.wideka.weixin.api.message.bo.Text;
import com.wideka.weixin.api.message.bo.Video;
import com.wideka.weixin.api.message.bo.Voice;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IMessageService {

	String HTTPS_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param text
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Text text, String safe)
		throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param image
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Image image,
		String safe) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param voice
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Voice voice,
		String safe) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param video
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Video video,
		String safe) throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param file
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, File file, String safe)
		throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param news
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, News news)
		throws RuntimeException;

	/**
	 * 
	 * @param accessToken
	 * @param toUser
	 * @param toParty
	 * @param toTag
	 * @param agentId
	 * @param mpNews
	 * @param safe
	 * @return
	 * @throws RuntimeException
	 */
	SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, MPNews mpNews,
		String safe) throws RuntimeException;

}
