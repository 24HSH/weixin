package com.wideka.weixin.message.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.wideka.club.framework.util.HttpUtil;
import com.wideka.club.framework.util.LogUtil;
import com.wideka.weixin.api.message.IMessageService;
import com.wideka.weixin.api.message.bo.File;
import com.wideka.weixin.api.message.bo.Image;
import com.wideka.weixin.api.message.bo.MPNews;
import com.wideka.weixin.api.message.bo.Message;
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
public class MessageServiceImpl implements IMessageService {

	private static Logger logger = Logger.getLogger(MessageServiceImpl.class);

	private SendResult send(String accessToken, Message message) throws RuntimeException {
		SendResult result = null;

		try {
			result =
				JSON.parseObject(
					HttpUtil.post(IMessageService.HTTPS_MESSAGE_URL + accessToken.trim(), JSON.toJSONString(message)),
					SendResult.class);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(message), e);

			throw new RuntimeException("HttpUtil error.", e);
		}

		if (result == null) {
			throw new RuntimeException("send_result is null.");
		}

		String errCode = result.getErrCode();
		if (StringUtils.isNotBlank(errCode) && !"0".equals(errCode)) {
			throw new RuntimeException(result.getErrMsg());
		}

		return result;
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Text text,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (text == null || StringUtils.isBlank(text.getContent())) {
			throw new RuntimeException("content cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("text");
		message.setAgentId(agentId);
		message.setText(text);
		message.setSafe(safe);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Image image,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (image == null || StringUtils.isBlank(image.getMediaId())) {
			throw new RuntimeException("media_id cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("image");
		message.setAgentId(agentId);
		message.setImage(image);
		message.setSafe(safe);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Voice voice,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (voice == null || StringUtils.isBlank(voice.getMediaId())) {
			throw new RuntimeException("media_id cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("voice");
		message.setAgentId(agentId);
		message.setVoice(voice);
		message.setSafe(safe);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, Video video,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (video == null || StringUtils.isBlank(video.getMediaId())) {
			throw new RuntimeException("media_id cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("video");
		message.setAgentId(agentId);
		message.setVideo(video);
		message.setSafe(safe);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, File file,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (file == null || StringUtils.isBlank(file.getMediaId())) {
			throw new RuntimeException("media_id cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("file");
		message.setAgentId(agentId);
		message.setFile(file);
		message.setSafe(safe);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, News news)
		throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (news == null || news.getArticleList() == null || news.getArticleList().size() == 0) {
			throw new RuntimeException("articles cannot be null.");
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("news");
		message.setAgentId(agentId);
		message.setNews(news);

		return send(accessToken, message);
	}

	@Override
	public SendResult send(String accessToken, String toUser, String toParty, String toTag, int agentId, MPNews mpNews,
		String safe) throws RuntimeException {
		if (StringUtils.isBlank(accessToken)) {
			throw new RuntimeException("access_token cannot be null.");
		}

		if (mpNews == null) {
			throw new RuntimeException("mpnews cannot be null.");
		}

		if (StringUtils.isBlank(mpNews.getMediaId())) {
			if (mpNews.getArticleList() == null || mpNews.getArticleList().size() == 0) {
				throw new RuntimeException("mpnews cannot be null.");
			}
		}

		Message message = new Message();
		message.setToUser(StringUtils.trim(toUser));
		message.setToParty(StringUtils.trim(toParty));
		message.setToTag(StringUtils.trim(toTag));
		message.setMsgType("mpnews");
		message.setAgentId(agentId);
		message.setMpNews(mpNews);
		message.setSafe(safe);

		return send(accessToken, message);
	}

}
