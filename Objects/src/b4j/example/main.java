package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 72;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return false;
}
public static String  _appstart(String[] _args) throws Exception{
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _reader = null;
anywheresoftware.b4j.object.JavaObject _sys = null;
String _output = "";
String _path = "";
anywheresoftware.b4a.objects.collections.List _lib_path = null;
String _temp = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _match = null;
int _i = 0;
String _lib = "";
 //BA.debugLineNum = 11;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 13;BA.debugLine="Log(CRLF)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 14;BA.debugLine="Log(\"Welcome to Library Extractor!\")";
anywheresoftware.b4a.keywords.Common.Log("Welcome to Library Extractor!");
 //BA.debugLineNum = 15;BA.debugLine="Log(\"You have to add libraries folder path in lib";
anywheresoftware.b4a.keywords.Common.Log("You have to add libraries folder path in lib_path.txt");
 //BA.debugLineNum = 16;BA.debugLine="Log(CRLF)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 18;BA.debugLine="Dim reader As TextReader";
_reader = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim sys As JavaObject";
_sys = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 20;BA.debugLine="sys.InitializeStatic(\"java.lang.System\")";
_sys.InitializeStatic("java.lang.System");
 //BA.debugLineNum = 21;BA.debugLine="reader.Initialize(sys.GetField(\"in\"))";
_reader.Initialize((java.io.InputStream)(_sys.GetField("in")));
 //BA.debugLineNum = 23;BA.debugLine="Dim output,path As String";
_output = "";
_path = "";
 //BA.debugLineNum = 24;BA.debugLine="Log(\"Input b4a project filename (b4a file): \")";
anywheresoftware.b4a.keywords.Common.Log("Input b4a project filename (b4a file): ");
 //BA.debugLineNum = 25;BA.debugLine="path	=	reader.ReadLine";
_path = _reader.ReadLine();
 //BA.debugLineNum = 27;BA.debugLine="Log(\"Input output library foder for extract: \")";
anywheresoftware.b4a.keywords.Common.Log("Input output library foder for extract: ");
 //BA.debugLineNum = 28;BA.debugLine="output	=	reader.ReadLine";
_output = _reader.ReadLine();
 //BA.debugLineNum = 30;BA.debugLine="Dim lib_path As List";
_lib_path = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 31;BA.debugLine="lib_path	=	File.ReadList(File.DirApp,\"lib_path.tx";
_lib_path = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"lib_path.txt");
 //BA.debugLineNum = 33;BA.debugLine="If File.Exists(\"\",path) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists("",_path)) { 
 //BA.debugLineNum = 35;BA.debugLine="Dim temp As String";
_temp = "";
 //BA.debugLineNum = 36;BA.debugLine="temp	=	File.ReadString(\"\",path)";
_temp = anywheresoftware.b4a.keywords.Common.File.ReadString("",_path);
 //BA.debugLineNum = 38;BA.debugLine="Dim match As Matcher";
_match = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 39;BA.debugLine="match	=	Regex.Matcher(\"Library\\d+=(\\S+)\",temp)";
_match = anywheresoftware.b4a.keywords.Common.Regex.Matcher("Library\\d+=(\\S+)",_temp);
 //BA.debugLineNum = 41;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 43;BA.debugLine="Do While match.Find";
while (_match.Find()) {
 //BA.debugLineNum = 45;BA.debugLine="Dim lib As String";
_lib = "";
 //BA.debugLineNum = 46;BA.debugLine="lib	=	match.Group(1)";
_lib = _match.Group((int) (1));
 //BA.debugLineNum = 48;BA.debugLine="If File.Exists(lib_path.Get(0),lib & \".jar\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(BA.ObjectToString(_lib_path.Get((int) (0))),_lib+".jar")) { 
 //BA.debugLineNum = 49;BA.debugLine="File.Copy(lib_path.Get(0),lib & \".jar\",output,";
anywheresoftware.b4a.keywords.Common.File.Copy(BA.ObjectToString(_lib_path.Get((int) (0))),_lib+".jar",_output,_lib+".jar");
 //BA.debugLineNum = 50;BA.debugLine="File.Copy(lib_path.Get(0),lib & \".xml\",output,";
anywheresoftware.b4a.keywords.Common.File.Copy(BA.ObjectToString(_lib_path.Get((int) (0))),_lib+".xml",_output,_lib+".xml");
 //BA.debugLineNum = 51;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }else {
 //BA.debugLineNum = 53;BA.debugLine="If lib_path.Size = 2 Then";
if (_lib_path.getSize()==2) { 
 //BA.debugLineNum = 54;BA.debugLine="If File.Exists(lib_path.Get(1),lib & \".jar\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(BA.ObjectToString(_lib_path.Get((int) (1))),_lib+".jar")) { 
 //BA.debugLineNum = 55;BA.debugLine="File.Copy(lib_path.Get(1),lib & \".jar\",outpu";
anywheresoftware.b4a.keywords.Common.File.Copy(BA.ObjectToString(_lib_path.Get((int) (1))),_lib+".jar",_output,_lib+".jar");
 //BA.debugLineNum = 56;BA.debugLine="File.Copy(lib_path.Get(1),lib & \".xml\",outpu";
anywheresoftware.b4a.keywords.Common.File.Copy(BA.ObjectToString(_lib_path.Get((int) (1))),_lib+".xml",_output,_lib+".xml");
 //BA.debugLineNum = 57;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 };
 };
 };
 }
;
 //BA.debugLineNum = 64;BA.debugLine="Log($\"${i} library copied to ${output} successfu";
anywheresoftware.b4a.keywords.Common.Log((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+" library copied to "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_output))+" successfully"));
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
}
