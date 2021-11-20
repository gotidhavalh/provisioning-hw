package com.voxloud.provisioning.device.factory;

import com.voxloud.provisioning.device.sevice.ConferenceDeviceConfiguration;
import com.voxloud.provisioning.device.sevice.DeskDeviceConfiguration;
import com.voxloud.provisioning.device.sevice.IDeviceConfiguration;
import com.voxloud.provisioning.entity.Device;

public class DeviceCreationFactory {

	public static IDeviceConfiguration getDeviceCofiguration(Device device) {

		switch (device.getModel()) {

		case CONFERENCE:
			return new ConferenceDeviceConfiguration();
		case DESK:
			return new DeskDeviceConfiguration();
		default:
			return null;
		}

	}
}
