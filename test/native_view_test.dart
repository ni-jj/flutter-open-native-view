import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:native_view/native_view.dart';

void main() {
  const MethodChannel channel = MethodChannel('native_view');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await NativeView.platformVersion, '42');
  });
}
