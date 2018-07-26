/*
 * @author Laxman Eluri
 *
 */

// every java.util.Date class in the vet package should be
// processed by DateAdapter
@XmlJavaTypeAdapter(value=DateAdapter.class, type=Date.class)
package com.laxel.framework.testreports;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.laxel.framework.helpers.DateAdapter;

import java.util.Date;

