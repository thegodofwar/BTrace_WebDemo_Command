/*
 * Copyright 2008-2010 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
  //假如该脚本位置是/bTrace/samples/下面；则执行该脚本命令为:btrace -cp ../build/ pid ./FindBug.java 
package com.sun.btrace.samples;

import com.sun.btrace.annotations.*;
import com.sun.btrace.AnyType;
import static com.sun.btrace.BTraceUtils.*;

/**
 * This sample demonstrates regular expression
 * probe matching and getting input arguments
 * as an array - so that any overload variant
 * can be traced in "one place". This example
 * traces any "readXX" method on any class in
 * java.io package. Probed class, method and arg
 * array is printed in the action.
 */
@BTrace public class FindBug {

    public static int tag;
	
	@OnMethod(
        clazz="/com.pw.spider.Util.HttpCrawler/",
        method="/crawl/"
    )
    public static void anyRead1(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		String url=str(args[2]);
		boolean isRightUrl=(indexOf(url,"http://www.qingdi.com") >= 0);
		if(isRightUrl) {
			tag++;
			println(strcat("tag=",str(tag)));
		    println(pcn);
		    println(url);
		    println(pmn);
		}	
    }

    @OnMethod(
	    clazz="/com.pw.spider.Util.HttpCrawler/",
	    method="/crawl/",
	    location=@Location(Kind.RETURN)
	)
    public static void anyRead2(@Return String result,@ProbeClassName String pcn, @ProbeMethodName String pmn) {
        if(tag==1) {
	      println(result);
          println(pcn);
          println(pmn);
		}  
	}

}
