Step 1.Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.lovemelon2017:HcToast:1.0.0'
	}
  
3使用:
  HcToastUtil.showShort("文字");
  可设置toast文字颜色，背景色，大小，位置
  自定义view
  xml布局的文字Id必须设置为   android:id="@+id/message";
	 
  View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_toast_layout, null);
	  
  HcToastUtil.showCustom("666",view);
