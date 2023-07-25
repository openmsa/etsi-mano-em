/**
 *     Copyright (C) 2019-2020 Ubiqube.
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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.em.client.vnfind;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;

import com.ubiqube.etsi.mano.em.v431.model.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.em.v431.model.vnfind.VnfIndicatorSubscriptionRequest;

@HttpExchange(url = "/vnfind/v1", accept = "application/json", contentType = "application/json")
public interface VnfIndSubscriptionRemoteService {

	ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(MultiValueMap<String, String> requestParams, @RequestParam(value = "nextpage_opaque_marker", required = false) final String nextpageOpaqueMarker);

	@PostMapping(value = "/subscriptions", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@RequestBody final VnfIndicatorSubscriptionRequest body);

	@DeleteMapping(value = "/subscriptions/{subscriptionId}", produces = { "application/json" })
	ResponseEntity<Void> subscriptionsSubscriptionIdDelete(@PathVariable("subscriptionId") final String subscriptionId);

	@GetMapping(value = "/subscriptions/{subscriptionId}", produces = { "application/json" })
	ResponseEntity<VnfIndicatorSubscription> subscriptionsSubscriptionIdGet(@PathVariable("subscriptionId") final String subscriptionId);

}
