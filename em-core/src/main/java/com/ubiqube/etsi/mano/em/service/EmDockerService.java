/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.em.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.docker.DockerService;
import com.ubiqube.etsi.mano.docker.RegistryInformations;

@Service
public class EmDockerService implements DockerService {

	@Override
	public void sendToRegistry(final InputStream is, final String filename, final RegistryInformations registry, final String imageName, final String tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyConnection(final RegistryInformations registry) {
		// TODO Auto-generated method stub
	}

}
