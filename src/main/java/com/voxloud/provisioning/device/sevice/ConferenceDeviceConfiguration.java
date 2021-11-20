package com.voxloud.provisioning.device.sevice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.voxloud.provisioning.entity.Device;

@Service
public class ConferenceDeviceConfiguration implements IDeviceConfiguration {

	@Value("${provisioning.domain}")
	private String domain;

	@Value("${provisioning.port}")
	private String port;

	@Value("${provisioning.codecs}")
	private String codecs;

	@Override
	public String getDeviceConfiguration(Device device) {
		Properties props = new Properties();
		props.put("username", device.getUsername());
		props.put("password", device.getPassword());
		props.put("domain", domain);
		props.put("port", port);
		props.put("codecs", device.getOverrideFragment());

		try {
			FileOutputStream outputStrem = new FileOutputStream("\\confrenceDevcie.properties");
			props.store(outputStrem, "File Stores");
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringWriter writer = new StringWriter();
		props.list(new PrintWriter(writer));
		return writer.getBuffer().toString();
	}

}
