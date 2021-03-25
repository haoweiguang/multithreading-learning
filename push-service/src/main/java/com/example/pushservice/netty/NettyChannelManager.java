package com.example.pushservice.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.util.AttributeKey;
import org.aopalliance.intercept.Invocation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author light.hao
 * @date 2021/1/29 5:59 下午
 */
@Component
public class ChannelHolder {
    private static final AttributeKey<String> CHANNEL_ATTR_KEY_USER = AttributeKey.newInstance("user");
    /**
     * Channel 映射
     */
    private ConcurrentMap<ChannelId, Channel> channels = new ConcurrentHashMap<>();
    private static final Map<String, Channel> channelMap = new ConcurrentHashMap<>();

    public void add(Channel channel) {
        channels.put(channel.id(), channel);
    }

    public void addUser(String key, Channel channel) {
        Channel existChannel = channels.get(channel.id());
        if (null == existChannel) {
            return;
        }
        channel.attr(CHANNEL_ATTR_KEY_USER).set(key);
        channelMap.put(key, channel);
    }

    public void send(String user, String message) {
        Channel channel = channelMap.get(user);
        if (null == channel) {
            return;
        }
        if (!channel.isActive()) {
            return;
        }
        channel.writeAndFlush(message);
    }

    public Channel get(String key) {
        return channelMap.get(key);
    }
}
