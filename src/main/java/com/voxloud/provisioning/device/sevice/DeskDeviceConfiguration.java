package com.voxloud.provisioning.device.sevice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.voxloud.provisioning.entity.Device;

@Service
public class DeskDeviceConfiguration implements IDeviceConfiguration {

	@Value("${provisioning.domain}")
	private String domain;

	@Value("${provisioning.port}")
	private String port;

	@Value("${provisioning.codecs}")
	private String codecs;

	@Override
	public String getDeviceConfiguration(Device device) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("username", device.getUsername());
		jsonObject.addProperty("password", device.getPassword());
		jsonObject.addProperty("domain", domain);
		jsonObject.addProperty("port", port);
		jsonObject.addProperty("codecs", codecs);
		
		String[] fragments = device.getOverrideFragment().split("\n");
		for(String fragment : fragments) {
			String[] frag = fragment.split(":");
			jsonObject.addProperty(frag[0], frag[1]);
		}
		return jsonObject.toString();
	}

}
