<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
   <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="he">
<head>
   <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>

<style>
body { margin: 0; font-family: verdana;  padding: 20px 50px 150px;  font-size: 13px;  text-align: center; }
h1 {text-align: center; margin: 0; padding: 5px;}
h2 {margin: 0; padding: 20px 0px 5px 0px;}
.header { top: 0px; height: 80px; border-bottom: 1px #ccc solid;background-color: #eaeaea; }
.footer { clear: both; overflow:hidden; border-top: 1px #ccc solid; padding: 10px 0px 0px 0px;}
.footer .text {float: right; margin-right: 20px;}
input[type="checkbox"] {display: inline !important; width: 20px; }
input { display: block; width: 340px; margin: 3px 0px 20px 0px; padding: 5px;}
label {font-weight: normal; font-size: 15px; display: block;}
button {background-color: #ccc; color: #000; border: 1px #f4f4f4 solid; margin: 12px 0px; box-shadow: 0 3px 2px #AAA; margin-right: 5px; padding: 5px 10px; font-weight: bold;}
#dialog {display: none;}
.ui-dialog{ box-shadow: 0 20px 10px #AAA;}
.error {border: 1px solid #FBB3B9; color: #f0051e; background: #FFECED; padding: 5px; margin-bottom: 10px; font-size: 12px;font-weight: bold; }
.link {padding: 0px 30px 20px 30px; background-color: #f4f4f4; border: 1px solid #ccc; font-family: verdana; width: 800px; margin: 0 auto; margin-top: 40px; margin-bottom: 40px;}
.login {width: 380px; margin: 0 auto; border: 1px solid #ccc; padding: 30px; margin-top: 80px;}
.login h2 {margin-top: 0px;}
.success {border: 1px solid green; color: green; background: #90EE90; padding: 5px; margin-bottom: 10px; font-size: 12px;font-weight: bold;}
table {width: 460px; margin: 0 auto; border: 1px solid #ccc; margin-bottom: 20px;border-collapse:collapse; }
tr {margin: 0px; }
th {text-align: left; border: 1px solid #ccc; padding: 5px;}
td {border: 1px solid #ccc; padding: 5px; }
ul {
  text-align: left;
  display: inline;
  margin: 0;
  padding: 15px 4px 17px 0;
  list-style: none;
  -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  -moz-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}
ul li {
  font: bold 12px/18px sans-serif;
  display: inline-block;
  margin-right: -4px;
  position: relative;
  padding: 15px 20px;
  background: #fff;
  cursor: pointer;
  -webkit-transition: all 0.2s;
  -moz-transition: all 0.2s;
  -ms-transition: all 0.2s;
  -o-transition: all 0.2s;
  transition: all 0.2s;
}
ul li:hover {
  background: #555;
  color: #fff;
}
ul li ul {
  padding: 0;
  position: absolute;
  top: 48px;
  left: 0;
  width: 150px;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  display: none;
  opacity: 0;
  visibility: hidden;
  -webkit-transiton: opacity 0.2s;
  -moz-transition: opacity 0.2s;
  -ms-transition: opacity 0.2s;
  -o-transition: opacity 0.2s;
  -transition: opacity 0.2s;
}
ul li ul li { 
  background: #555; 
  display: block; 
  color: #fff;
  text-shadow: 0 -1px 0 #000;
}
ul li ul li:hover { background: #666; }
ul li:hover ul {
  display: block;
  opacity: 1;
  visibility: visible;
}

</style>

</head>
<body dir="rtl">
<div class="header">
<h1>MenuApp</h1>
<ul>
  <li><a href="/menuapp/">מסעדות</a></li>
  <li>דוחות</li>
  <li>סטטוס</li>
  <li>צור קשר</li>
  <li><a href="/menuapp/admin/">מנהל</a></li>
</ul>

</div>




