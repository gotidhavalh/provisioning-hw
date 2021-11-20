package com.voxloud.provisioning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voxloud.provisioning.device.factory.DeviceCreationFactory;
import com.voxloud.provisioning.device.sevice.IDeviceConfiguration;
import com.voxloud.provisioning.entity.Device;
import com.voxloud.provisioning.repository.DeviceRepository;

@Service
public class ProvisioningServiceImpl implements ProvisioningService {

	@Autowired
	private DeviceRepository deviceRepository;

	public String getProvisioningFile(String macAddress) {

		Device device = deviceRepository.getOne(macAddress);
		IDeviceConfiguration deviceConf = DeviceCreationFactory.getDeviceCofiguration(device);

		if (deviceConf == null)
			return "";
		else
			return deviceConf.getDeviceConfiguration(device);

	}
}
