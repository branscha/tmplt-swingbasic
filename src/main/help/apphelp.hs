<?xml version='1.0' encoding='ISO-8859-1' ?>

<!--
  ~ Template "tmplt-swingbasic".
  ~ Copyright (c) 2011 Bruno Ranschaert, SDI-Consulting BVBA.
  ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a copy
  ~ of this software and associated documentation files (the "Software"), to deal
  ~ in the Software without restriction, including without limitation the rights
  ~ to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  ~ copies of the Software, and to permit persons to whom the Software is
  ~ furnished to do so, subject to the following conditions:
  ~
  ~ The above copyright notice and this permission notice shall be included in
  ~ all copies or substantial portions of the Software.
  ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  ~ IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  ~ FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  ~ AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  ~ LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  ~ OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  ~ THE SOFTWARE.
  -->

<!DOCTYPE helpset
PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 2.0//EN"
         "http://java.sun.com/products/javahelp/helpset_2_0.dtd">

<helpset version="2.0">

   <title>Application Help Topics</title>

    <maps>
        <homeID>intro</homeID>
        <mapref location="apphelp-map.jhm"/>
    </maps>

    <view mergetype="javax.help.UniteAppendMerge">
        <name>TOC</name>
        <label>Table Of Contents</label>
        <type>javax.help.TOCView</type>
        <data>apphelp-toc.xml</data>
    </view>

    <view mergetype="javax.help.SortMerge">
        <name>Index</name>
        <label>Index</label>
        <type>javax.help.IndexView</type>
        <data>apphelp-index.xml</data>
    </view>

    <!-- Search database need to be generated in order to activate this view, see the notes. -->

    <!--<view >-->
    <!--<name>Search</name>-->
    <!--<label>Search</label>-->
    <!--<type>javax.help.SearchView</type>-->
    <!--<data engine="com.sun.java.help.search.DefaultSearchEngine">-->
    <!--JavaHelpSearch-->
    <!--</data>-->
    <!--</view>-->

    <presentation default="true">
        <name>main window</name>
        <size width="647" height="400"/>
        <location x="200" y="200"/>
        <title>Application Help Topics</title>
    </presentation>

</helpset>

