	function getajaxHttp() {
            var xmlHttp;
            try {
                // Firefox, Opera 8.0+, Safari  
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                // Internet Explorer  
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("您的浏览器不支持AJAX！");
                        return false;
                    }
                }
            }
            return xmlHttp;
        }
        /** 
         * 发送ajax请求 
         * url--请求到服务器的URL 
         * methodtype(post/get) 
         * con (true(异步)|false(同步)) 
         * functionName(回调方法名，不需要引号,这里只有成功的时候才调用) 
         * (注意：这方法有二个参数，一个就是xmlhttp,一个就是要处理的对象) 
         */
        function ajaxrequest(url, methodtype, con, functionName) {
            //获取XMLHTTPRequest对象
            var xmlhttp = getajaxHttp();
            //设置回调函数（响应的时候调用的函数）
            xmlhttp.onreadystatechange = function() {
                //这个函数中的代码在什么时候被XMLHTTPRequest对象调用？
                //当服务器响应时，XMLHTTPRequest对象会自动调用该回调方法
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        functionName(xmlhttp.responseText);
                    }
                }
            };
            //创建请求
            xmlhttp.open(methodtype, url, con);
            //发送请求
            xmlhttp.send();
        }
        function checkUsername() {
            var username=document.getElementById('userName').value;
            //调用ajax请求Servlet
            ajaxrequest("checkUser.do?userName="+username,"POST",true,ckUsernameResponse);
        }
        function ckUsernameResponse(responseContents){
            if (responseContents == 'yes') {
                document.getElementById('td_1').innerHTML="<font color='red'>用户名已存在！</font>";
                document.getElementById('userName').style="background-color: red";
            }else{
                document.getElementById('td_1').innerHTML="<font color='green'>恭喜！该用户名可以使用</font>";
                document.getElementById('userName').style="background-color: white";
            }
        }
