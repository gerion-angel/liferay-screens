/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.screens.service.v62;

import com.liferay.mobile.android.service.BaseService;
import com.liferay.mobile.android.service.JSONObjectWrapper;
import com.liferay.mobile.android.service.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Bruno Farache
 */
public class MobilewidgetsddlrecordService extends BaseService {

	public MobilewidgetsddlrecordService(Session session) {
		super(session);
	}

	public JSONObject getDdlRecord(long ddlRecordId, String locale) throws Exception {
		JSONObject _command = new JSONObject();

		try {
			JSONObject _params = new JSONObject();

			_params.put("ddlRecordId", ddlRecordId);
			_params.put("locale", locale);

			_command.put("/mobile-widgets-web/mobilewidgetsddlrecord/get-ddl-record", _params);
		}
		catch (JSONException _je) {
			throw new Exception(_je);
		}

		JSONArray _result = session.invoke(_command);

		if (_result == null) {
			return null;
		}

		return _result.getJSONObject(0);
	}

	public JSONArray getDdlRecords(long ddlRecordSetId, String locale, int start, int end) throws Exception {
		JSONObject _command = new JSONObject();

		try {
			JSONObject _params = new JSONObject();

			_params.put("ddlRecordSetId", ddlRecordSetId);
			_params.put("locale", locale);
			_params.put("start", start);
			_params.put("end", end);

			_command.put("/mobile-widgets-web/mobilewidgetsddlrecord/get-ddl-records", _params);
		}
		catch (JSONException _je) {
			throw new Exception(_je);
		}

		JSONArray _result = session.invoke(_command);

		if (_result == null) {
			return null;
		}

		return _result.getJSONArray(0);
	}

	public JSONArray getDdlRecords(long ddlRecordSetId, long userId, String locale, int start, int end) throws Exception {
		JSONObject _command = new JSONObject();

		try {
			JSONObject _params = new JSONObject();

			_params.put("ddlRecordSetId", ddlRecordSetId);
			_params.put("userId", userId);
			_params.put("locale", locale);
			_params.put("start", start);
			_params.put("end", end);

			_command.put("/mobile-widgets-web/mobilewidgetsddlrecord/get-ddl-records", _params);
		}
		catch (JSONException _je) {
			throw new Exception(_je);
		}

		JSONArray _result = session.invoke(_command);

		if (_result == null) {
			return null;
		}

		return _result.getJSONArray(0);
	}

	public Integer getDdlRecordsCount(long ddlRecordSetId) throws Exception {
		JSONObject _command = new JSONObject();

		try {
			JSONObject _params = new JSONObject();

			_params.put("ddlRecordSetId", ddlRecordSetId);

			_command.put("/mobile-widgets-web/mobilewidgetsddlrecord/get-ddl-records-count", _params);
		}
		catch (JSONException _je) {
			throw new Exception(_je);
		}

		JSONArray _result = session.invoke(_command);

		if (_result == null) {
			return null;
		}

		return _result.getInt(0);
	}

	public Integer getDdlRecordsCount(long ddlRecordSetId, long userId) throws Exception {
		JSONObject _command = new JSONObject();

		try {
			JSONObject _params = new JSONObject();

			_params.put("ddlRecordSetId", ddlRecordSetId);
			_params.put("userId", userId);

			_command.put("/mobile-widgets-web/mobilewidgetsddlrecord/get-ddl-records-count", _params);
		}
		catch (JSONException _je) {
			throw new Exception(_je);
		}

		JSONArray _result = session.invoke(_command);

		if (_result == null) {
			return null;
		}

		return _result.getInt(0);
	}

}