/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.em.client.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.ubiqube.etsi.mano.vnfm.property.EmProperty;

import io.micrometer.observation.ObservationRegistry;

/**
 *
 * @author Olivier Vignaud
 *
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(ObservationRegistry.class)
public class ClientConfigBean extends AbstractClientConfigBean {
	private final EmProperty conf;

	public ClientConfigBean(final EmProperty conf) {
		this.conf = conf;
	}

	@Override
	protected HttpServiceProxyFactory createProxyFactory() {
		final Builder webBuilder = WebClient.builder()
				.baseUrl(conf.getUrl());
		Optional.ofNullable(conf.getVersion()).ifPresent(x -> webBuilder.defaultHeader("Version", x));
		final WebClient client = webBuilder
				.build();
		return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
	}
}
