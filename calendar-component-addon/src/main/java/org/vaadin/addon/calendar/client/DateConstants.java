/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.addon.calendar.client;

import org.vaadin.addon.calendar.client.ui.schedule.CalDate;
import org.vaadin.addon.calendar.client.ui.schedule.CalTime;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @since 7.1
 *
 */

@SuppressWarnings({"deprecation"})
public class DateConstants implements Serializable {

    public static final String TIME_FORMAT_PATTERN = "HH:mm:ss";
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final String ACTION_DATE_TIME_FORMAT_PATTERN = DATE_FORMAT_PATTERN + " " + TIME_FORMAT_PATTERN;

    public static final long MINUTEINMILLIS = 60 * 1000;
    public static final long HOURINMILLIS = 60 * MINUTEINMILLIS;
    public static final long DAYINMILLIS = 24 * HOURINMILLIS;
    public static final long WEEKINMILLIS = 7 * DAYINMILLIS;

    public static final int DAYINMINUTES = 24 * 60;
    public static final int HOURINMINUTES = 60;

    public static Date toClientDate(CalDate date) {
        return new Date(date.y -1900, date.m -1, date.d, 0, 0, 0);
    }

    public static Date toClientDateTime(CalDate date) {
        return new Date(date.y -1900, date.m -1, date.d, date.t.h, date.t.m, date.t.s);
    }

    public static CalDate toRPCDateTime(Date date) {
        return new CalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate(),
                new CalTime(date.getHours(), date.getMinutes(), date.getSeconds()));
    }

    public static CalDate toRPCDate(Date date) {
        return new CalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }

    public static CalDate toRPCDate(int year, int month, int day) {
        return new CalDate(year + 1900, month + 1, day);
    }

}
