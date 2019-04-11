package cn.joyfollow.native_view;

import android.content.Intent;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** NativeViewPlugin */
public class NativeViewPlugin implements MethodCallHandler {
    private Registrar registrar;
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "native_view");
    channel.setMethodCallHandler(new NativeViewPlugin(registrar));
  }
    NativeViewPlugin(Registrar registrar){
      this.registrar = registrar;
    }
  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("openActivity")) {
        registrar.activity().startActivity(new Intent(registrar.activity(),NativeActivity.class));
//      result.success("Android " + android.os.Build.VERSION.RELEASE);
        result.success("success");
    } else {
      result.notImplemented();
    }
  }
}
