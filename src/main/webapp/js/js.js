/**
 * 
 */
function loginCheck()
{
	
	if(document.myform.userid.value.length == 0)
	{
		alert('아이디를 써주세요');
		myform.userid.focus();
		return false;
	}
	
	if(document.myform.pwd.value=="")
	{
		alert('암호는 반드시 입력해야 합니다.');
		myform.pwd.focus();
		return false;
	}
	
	return true;
}


function joinCheck()
{
	//*p500
	
	if(document.myform.name.value.length ==0)
	{
		alert('이름을 써주세요');
		myform.name.focus();
		return false;
	}
		
	if(document.myform.userid.value.length == 0)
	{
		alert('아이디를 써주세요');
		myform.userid.focus();
		return false;
	}

	if(document.myform.userid.value.length < 4)
	{
		alert('아이디는 4글자 이상이어야 합니다.');
		myform.userid.focus();
		return false;
	}	
	
	if(document.myform.pwd.value=="")
	{
		alert('암호는 반드시 입력해야 합니다.');
		myform.pwd.focus();
		return false;
	}
	
	if(document.myform.pwd.value != document.myform.pwd_check.value)
	{
		alert('암호가 일치하지 않습니다.');
		myform.pwd.focus();
		return false;
	}		
	
	if(document.myform.reid.value.length == 0)
	{
		alert('중복 체크를 하지 않았습니다.');
		myform.userid.focus();
		return false;
	}		
		
	return true;
}

function idCheck()
{
	if(document.myform.userid.value == "")
	{
		alert('아이디를 써주세요');
		document.myform.usreid.focus();
		return;
	}
	
	var url="idCheck.do?userid="+document.myform.userid.value;
	window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbar=yes,resizable=no,width=500,height=300");
		
}

function idok(){
	opener.myform.userid.value=document.myform.userid.value;
	opener.myform.reid.value=document.myform.userid.value;	
	self.close();
}

