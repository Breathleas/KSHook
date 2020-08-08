package com.example.ksxposed.hook;

import android.util.Log;

import com.example.ksxposed.google.C19514i;
import com.example.ksxposed.util.Utils;
import com.google.protobuf.nano.MessageNano;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import g.d0.g0.a.i;

import static com.example.ksxposed.config.Config.KS_PackageName;
import static com.example.ksxposed.config.Config.TAG;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findConstructorBestMatch;

/**
 * Created by Administrator on 2020/7/14.
 */

public class HookMain implements IXposedHookLoadPackage{

    private boolean NETWORK = true;
    private boolean HTTP_DATA = true;
    private boolean SOCKET_DATA = true;

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        final String packageName = lpparam.packageName;
//        Log.d(TAG,"packageName "+packageName);
        if (packageName.equals(KS_PackageName)){
            Log.d(TAG,"hook kuaishou start");

            hookMethod(lpparam.classLoader);
        }
    }

    private void hookMethod(ClassLoader classLoader) {
        hook(classLoader);
    }

    private Object g0Curr;
    private static int count = 1;

    /**
     *
     * @param classLoader
     */
    private void hook(final ClassLoader classLoader){


        hook_ScFeed(classLoader);

//        hook_zbbz(classLoader);
//        /////////////
        getTCPHostAndPort(classLoader);


//
//        hookSocketInfo(classLoader);
//        /**
//         * z.b.f.p.l -> a
//         */
//        hook_zbfpl(classLoader);
//
//        /**
//         * z.b.f.q.f0 -> a
//         */
//        hook_zbfqfo(classLoader);
//
//        /**
//         *  hook z.b.d.a.b -> a
//         */
//        hook_zbdab(classLoader);
//
//        /**
//         *  hook z.b.b.a -> b,j
//         *
//         */
//        hook_zbba(classLoader);
//
//        /**
//         *  hook z.b.c.a -> a
//         *
//         */
//        hook_zbca(classLoader);
        /**
         *  hook z.b.d.a.a -->a
         */
//        hook_zbdaa(classLoader);
        /**
         * hook z.b.b.b -> a
         */
//        hook_zbbb(classLoader);
        /**
         * hook z.b.c.c -> b
         */
//        hook_zbcc(classLoader);

//        /**
//         *  hook z.b.b.x -> e
//         */
//        hook_zbbx(classLoader);
        /**
         *  hook g.d0.g.b.m -> a
         *     messageNano拼接
         */
        hook_gd0gbm(classLoader);
    }

    private void hook_zbcc(ClassLoader classLoader) {
        try {
            Class<?> cClass = classLoader.loadClass("z.b.c.c");
            final Class<?> iClass = XposedHelpers.findClass("g.d0.g0.a.i", classLoader);
            findAndHookMethod(cClass, "b", Object.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object obj = param.args[0];
                    if (iClass.isInstance(obj)){
                        byte[] bytes = (byte[]) obj.getClass().getField("c").get(obj);
                        int b = (int) obj.getClass().getField("b").get(obj);
                        Log.d(TAG, "z.b.c.c -> b: 参数是messageNano g.d0.g0.a.i -->b: "+b+" ----- g.d0.g0.a.i -->c bytes: "+Utils.bytesToHexString(bytes));
                    }else {
                        Log.d(TAG, "z.b.c.c -> b: 参数是："+obj.getClass().getName());
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    private void hook_zbdaa(final ClassLoader classLoader) {
        try {
            final Class<?> aClass = classLoader.loadClass("z.b.d.a.a");
            final Class<?> kClass = XposedHelpers.findClass("z.b.c.k", classLoader);
            final Class<?> eClass = XposedHelpers.findClass("z.b.b.e", classLoader);
//            findAndHookMethod(aClass, "a", kClass, Object.class, new XC_MethodHook() {
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Object kk = param.args[0];
//
//                    Object obj = param.args[1];
//                }
//            });

            findAndHookMethod(aClass, "a", kClass, eClass, List.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    List list = (List) param.args[2];
                    int size = list.size();
                    if (size > 0){
                        Log.d(TAG, "z.b.d.a.a -> 第二个a: size: "+size);
                    }
                }
            });


            findAndHookMethod(aClass,"a",kClass,List.class,int.class,new XC_MethodHook(){
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    List<Object> list = (List) param.args[1];
                    int i = (int) param.args[2];
                    for (int i2 = 0; i2 < i; i2++) {
                        Object o = list.get(i2);
                        Log.d(TAG, "z.b.d.a.a -> 第三个a: list里的值类型："+o.getClass().getName() +" 值："+o);
                        if (o instanceof MessageNano)
                            Log.d(TAG, "z.b.d.a.a -> 第三个a: list里的值 返回值字节："+Utils.bytesToHexString(MessageNano.toByteArray((MessageNano) o)) );
                    }

                }
            });

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook_zbdaa: z.b.d.a.a没找到");
        }
    }

    private void hook_zbbb(ClassLoader classLoader) {
        try {
            Class<?> bClass = classLoader.loadClass("z.b.b.b");
            findAndHookMethod(bClass, "a", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (count == 3)
                        Log.d(TAG, "z.b.b.b->a: 堆栈："+Log.getStackTraceString(new Throwable()));
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    int i = (int) param.args[0];
                    Object result = param.getResult();
                    Log.d(TAG, "z.b.b.b -> a: 参数i= "+i+" 返回值："+result );
                    if (result instanceof MessageNano){
                        Log.d(TAG, "z.b.b.b -> a: 参数i= "+i+" 返回值是MessageNano 字节："+Utils.bytesToHexString(MessageNano.toByteArray((MessageNano) result)) );
                    }

                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    private void hook_zbbx(ClassLoader classLoader) {
        try {
            Class<?> xClass = classLoader.loadClass("z.b.b.x");
            findAndHookMethod(xClass, "e", int.class, int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    int i1 = (int) param.args[0];  int i2 = (int) param.args[1];
                    Object result = param.getResult();
                    Log.d(TAG, "z.b.b.x -> e: 参数1："+i1+" 参数2："+i2);
                    Log.d(TAG, "z.b.b.x -> e: 返回值： "+result);
                    Log.d(TAG, "z.b.b.x -> e: 返回值 字节： "+Utils.bytesToHexString((byte[]) result));
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook_zbbx: z.b.b.x没找到");
        }

    }

    private void hook_ScFeed(ClassLoader classLoader) {
        try {
            Class<?> ScFeedPush = classLoader.loadClass("com.kuaishou.livestream.message.nano.LiveStreamMessages$SCFeedPush");
            findAndHookMethod(ScFeedPush, "parseFrom", byte[].class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    if (count == 1 || count == 2 || count == 3){
                        Log.d(TAG, "SCFeedPush -> parseFrom堆栈: "+Log.getStackTraceString(new Throwable()));
                        count++;
                    }
                    synchronized (this){
                        byte[] bytes = (byte[]) param.args[0];
                        String hexString = Utils.bytesToHexString(bytes);
                        Object result = param.getResult();
                        Log.d(TAG, "LiveStreamMessages$SCFeedPush: 参数byte: "+hexString);
                        Log.d(TAG, "LiveStreamMessages$SCFeedPush: 返回值: "+result);
                    }


                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook_ScFeed: LiveStreamMessages$SCFeedPush没找到");
        }
    }

    private void hook_gd0gbm(ClassLoader classLoader) {
        try {
            final Class<?> mClass = classLoader.loadClass("g.d0.g.b.m");
            findAndHookMethod(mClass, "a", MessageNano.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object messageNano = param.args[0];
                    Object result = param.getResult();
//                    byte[] bytes = MessageNano.toByteArray((MessageNano) messageNano);
                    synchronized (this){
//                        Log.d(TAG, "g.d0.g.b.m -> a: MessageNano.toByteArray(messageNano)-->  bytes: "+bytes);
                        Log.i(TAG, "g.d0.g.b.m -> a:  messageNano拼接参数: {"+messageNano+"}\n g.d0.g.b.m -> a: 返回值：{"+result+"}");
                    }
                }
            });
            Class<?> aClass = XposedHelpers.findClass("g.d0.g.b.o.a", classLoader);
            findAndHookMethod(mClass, "a", int.class, Class.class, aClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    int i = (int) param.args[0];
                    Object arg2 = param.args[1];
                    String name = arg2.getClass().getName();
                    Log.d(TAG, "g.d0.g.b.m -> a: int : "+i+" class name: "+name);
                }
            });

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: g.d0.g.b.m未找到");
        }
    }

    private void hook_zbca(ClassLoader classLoader) {
        try {
            final Class<?> a = classLoader.loadClass("z.b.c.a");
            findAndHookMethod(a, "a", Object.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object arg = param.args[0];
                    Log.d(TAG, "z.b.c.a -> a--> "+arg);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.c.a未找到");
        }



    }


    private void hook_zbba(ClassLoader classLoader) {
        try {
            Class<?> aClass = classLoader.loadClass("z.b.b.a");
            findAndHookMethod(aClass, "b", byte[].class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    byte[] bytes = (byte[]) param.args[0];
                    Log.d(TAG, "z.b.b.a -> b bytes长度: "+bytes.length+" 打印字节: "+ Utils.bytesToHexString(bytes));
                }
            });

            findAndHookMethod(aClass, "j", int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    int i = (int) param.args[0];
                    Log.d(TAG, "z.b.b.a -> j : 打印参数int: "+ i);
                }
            });

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.b.a未找到");
        }
    }

    private void hook_zbdab(ClassLoader classLoader) {
        try {
            Class<?> bClass = classLoader.loadClass("z.b.d.a.b");
            Class<?> kClass = XposedHelpers.findClass("z.b.c.k", classLoader);
            Class<?> wClass = XposedHelpers.findClass("z.b.c.w", classLoader);

            findAndHookMethod(bClass, "a", kClass, Object.class, wClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object arg = param.args[1];
                    Log.d(TAG, "z.b.d.a.b -> a 写入object "+arg);

                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.d.a.b未找到");
        }

    }

    private void hook_zbfqfo(ClassLoader classLoader) {
        try {
            Class<?> f0Class = classLoader.loadClass("z.b.f.q.f0");
            findAndHookMethod(f0Class, "a", Object.class, Class.class, String.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object obj = param.args[0];
                    Class clazz = (Class) param.args[1];
                    String str = (String) param.args[2];
//                    Log.d(TAG, "z.b.f.q.f0->a: Object: "+obj.getClass().getName()+" class: "+clazz.getName()+" String: "+str);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.f.q.f0未找到");
        }
    }

    private void hook_zbfpl(ClassLoader classLoader) {
        try {
            Class<?> lClass = classLoader.loadClass("z.b.f.p.l");
            final Class<?> fClass = XposedHelpers.findClass("z.b.f.q.f",classLoader);
            findAndHookMethod(lClass, "a", fClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object result = param.getResult();
                    if (result instanceof ByteBuffer[]){
                        printByteBuffer("z.b.f.p.l->a :a2值",(ByteBuffer[]) result);
                    }else {
//                        Log.d(TAG, "z.b.f.p.l -> a: 返回值不是byteBuffer类型: "+result.getClass().getName());
                    }

                }
            });

            /**
             * hook z.b.f.q.g0->g0
             */
            try {
                Class<?> g0Class = classLoader.loadClass("z.b.f.q.g0");
                findAndHookConstructor(g0Class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
//                        Log.d(TAG, "z.b.f.q.g0 获取g0实例对象: "+param.thisObject.getClass().getName());
                        g0Curr = param.thisObject;
                        Object[] objects = (Object[]) param.args[0];
                        for (int i = 0; i < objects.length; i++) {
                            if (objects[i] instanceof ByteBuffer[]){
                                printByteBuffer("z.b.f.q.g0 -> g0 objArr["+i+"]", (ByteBuffer[]) objects[i]);
                            }else {
//                                Log.d(TAG, "z.b.f.q.g0 -> g0: 不是byteBuffer类型: objArr["+i+"] "+objects[i].getClass().getName());
                            }
                        }

//                    Log.d(TAG,"z.b.f.q.g0-->g0构造函数，堆栈调用： "+Log.getStackTraceString(new Throwable()));

                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.d(TAG, "hook: z.b.f.q.g0未找到");
            }

            /**
             *  hook :  z.b.f.q.f --> a
             *
             * public Object mo119750a(int i) {
             *         Object[] objArr = this.f178806a;
             *         if (i < objArr.length) {
             *             return objArr[i];
             *         }
             *         return f178798j;---> ByteBuffer
             *     }
             */
            findAndHookMethod(fClass, "a", int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    int i = (int) param.args[0];
//                    Log.d(TAG, "z.b.f.q.f->a int: "+i);
                    Field[] fields = fClass.getFields();
                    for (Field field :fields) {
                        if (field.getName().equals("a")){
                            field.setAccessible(true);

                            Object[] f178806a = (Object[]) field.get(g0Curr);
                            int length = f178806a.length;

                            if (i < length){
                                if (f178806a[i] instanceof ByteBuffer[]){
                                    printByteBuffer("z.b.f.q.f->a: 获取f178806a里面的值 参数i== "+i, (ByteBuffer[]) f178806a[i]);
                                }else {
//                                    Log.d(TAG, "z.b.f.q.f->a: f178806a不是byteBuffer类型: "+f178806a.getClass().getName());
                                }

//                                Log.i(TAG, "z.b.f.q.f->a: (i < objArr.length) 返回objArr["+i+"]"+" objArr.length: "+length);

                            }else {
                                Log.i(TAG, "z.b.f.q.f->a: 返回f178798j");
                            }
                        }
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.f.p.l未找到");
        }
    }

    private void hook_zbbz(ClassLoader classLoader) {
        try {
            Class<?> aClass = classLoader.loadClass("z.b.b.z");

                findAndHookMethod(aClass, "a", int.class,
                        ScatteringByteChannel.class, int.class, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                super.beforeHookedMethod(param);
//                                if (count == 2)
//                                    Log.d(TAG,"z.b.b.z-->a堆栈调用： "+Log.getStackTraceString(new Throwable()));
                            }

                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                int i1 = (int) param.args[0];
                                int i2 = (int) param.args[2];


                                ScatteringByteChannel channel = (ScatteringByteChannel) param.args[1];
//                                ByteBuffer buf = ByteBuffer.allocate(1024);
//
//                                int read = channel.read(buf);
//                                byte[] array = buf.array();
//                                Log.d(TAG, "z.b.b.z->a  i1: "+i1+" i2:"+i2+"\n"+
//                                        "z.b.b.z->a buffer 16进制: "+ Utils.bytesToHexString(array)
//                                );
                                Log.d(TAG, "z.b.b.z->a  i1: "+i1+" i2:"+i2+" channel.isOpen(): "+channel.isOpen());

                            }
                        });

//
//                findAndHookMethod(aClass, "b", int.class, byte[].class, int.class, int.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
////                        Log.d(TAG,"z.b.b.z-->b堆栈调用： "+Log.getStackTraceString(new Throwable()));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        int i1 = (int) param.args[0];
//                        int i2 = (int) param.args[2];
//                        int i3 = (int) param.args[3];
//                        byte[] bytes = (byte[]) param.args[1];
//
//                        Log.d(TAG, "z.b.b.z->b: i1=="+i1+" i2=="+i2+" i3=="+i3+"\n"+
//                                "z.b.b.z->b: byte[]16进制 "+Utils.bytesToHexString(bytes)
//                        );
//
//                    }
//                });
//                findAndHookMethod(aClass, "a", int.class, byte[].class, int.class, int.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
////                        Log.d(TAG,"z.b.b.z-->b堆栈调用： "+Log.getStackTraceString(new Throwable()));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        int i1 = (int) param.args[0];
//                        int i2 = (int) param.args[2];
//                        int i3 = (int) param.args[3];
//                        byte[] bytes = (byte[]) param.args[1];
//
//                        Log.d(TAG, "z.b.b.z->a: i1=="+i1+" i2=="+i2+" i3=="+i3+"\n"+
//                                "z.b.b.z->a: byte[]16进制 "+Utils.bytesToHexString(bytes)
//                        );
//
//                    }
//                });

        /**
         * hook
         *
         * public final int mo119314a(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) throws IOException {
         *         ByteBuffer byteBuffer;
         *         mo119157H();
         *         if (z) {
         *             byteBuffer = mo119313M();
         *         } else {
         *             byteBuffer = ByteBuffer.wrap(this.f178347l);
         *         }
         *         return gatheringByteChannel.write((ByteBuffer) byteBuffer.clear().position(i).limit(i + i2));
         *     }
         */
//                findAndHookMethod(aClass, "a", int.class, GatheringByteChannel.class, int.class, Boolean.class, new XC_MethodHook() {
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        int i1 = (int) param.args[0];int i2 = (int) param.args[2]; boolean z = (boolean) param.args[3];
//                        GatheringByteChannel channel = (GatheringByteChannel) param.args[1];
//
//
//                    }
//                });

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.d(TAG, "hook: z.b.b.z未找到");
            }
    }

    /**
     *  hook z.b.c.w0.e.b-->a
     *
     *  public void mo119323a(C76588s sVar) throws Exception {

     *  public final class C76588s --- z.b.c.s
     */
    private void hookSocketInfo(final ClassLoader classLoader) {

        try {
            final Class<?> bClass = classLoader.loadClass("z.b.c.w0.e.b");
            final Class<?> sClass = XposedHelpers.findClass("z.b.c.s",classLoader);
            findAndHookMethod(bClass, "a", sClass, new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Class<?> b = XposedHelpers.findClass("z.b.c.v0.b", classLoader);
                    hookSocketChannel(param,b);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    /** public final class C76588s {}*/
                    Object sVar = param.args[0];
                    /** public int f178512e; renamed from: e */
                    Integer f178512e = (int) sVar.getClass().getField("e").get(sVar);
                    /** public C76592d f178509b; z.b.c.s$d */
                    Object dvar2 = sVar.getClass().getField("b").get(sVar);
                    if (dvar2 == null){
                        Log.d(TAG, "z.b.c.s$d -> f178509b:为空");
                        return;
                    }
                    int f178532j = (int) dvar2.getClass().getField("j").get(dvar2);
                    if (f178512e == null) {
                        Log.d(TAG, "f178512e:为空");
                        return;
                    }
                    Log.d(TAG, "z.b.c.w0.e.b->a : f178512e -> "+f178512e+ " f178532j-> "+f178532j);

                }
            });


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.c.w0.e.b未找到");
        }
    }

    private void getTCPHostAndPort(ClassLoader classLoader) {
        /**
         * public C76557g mo119152a(String str, int i) {
         * }
         */
        try {
            Class<?> aClass = classLoader.loadClass("z.b.a.c");
            findAndHookMethod(aClass, "a", String.class, int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    String host = (String) param.args[0];int port = (int) param.args[1];
                    Log.d(TAG, "z.b.a.c->a tcp连接的host: "+host + " port: "+port);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.a.c未找到");
        }
    }

    private void printByteBuffer(String tag,ByteBuffer[] result) {
        if (result == null){
            Log.d(TAG, "printByteBuffer--> "+tag + "buffer为空");
            return;
        }
        int length = result.length;
        synchronized (this){
            for (int i = 0; i < length; i++) {
                ByteBuffer buffers = result[i];
                if (buffers!= null){
                    byte[] array = buffers.array();
                    Log.d(TAG, "printByteBuffer--> "+tag+" 获取 ByteBuffer i: "+i+" buffer16进制: "+Utils.bytesToHexString(array));
                }

            }
        }
    }

    private void hookSocketChannel(XC_MethodHook.MethodHookParam param, Class<?> bClass) {
        Field[] fields = bClass.getFields();
        for (Field field : fields) {
            if (field.getName().equals("w")){
                try {
                    SocketChannel o = (SocketChannel) field.get(bClass);
                    Log.d(TAG, "z.b.c.w0.e.b->a : 获取到socketChannel实例 isConnected "+o.isConnected()+" isRegistered: "+o.isRegistered()+
                            " isOpen: "+o.isOpen());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    Log.d(TAG, "z.b.c.w0.e.b->a : 获取到socketChannel实例异常");
                }
            }


        }

    }

    private void hookStream(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        Class<?> aClass = lpparam.classLoader.loadClass("java.io.OutputStream");
        Log.d(TAG, "hookStream: 加载类："+aClass.getName());
        findAndHookMethod(aClass, "write", Byte[].class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(TAG, "hookSocketChannel write beforeHookedMethod ");

                Log.d(TAG,"write堆栈调用： "+Log.getStackTraceString(new Throwable()));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.d(TAG, "afterHookedMethod: ");
            }
        });
    }

    private void hookSocketChannel(XC_LoadPackage.LoadPackageParam lpparam) throws Exception {
        Class<?> aClass = lpparam.classLoader.loadClass("java.nio.channels.SocketChannel");

        Class<?> b = XposedHelpers.findClass("z.b.c.v0.b", lpparam.classLoader);
        Field w = b.getField("w");
        Log.d(TAG, "hookSocketChannel: 加载类："+aClass.getName());


        findAndHookMethod(aClass, "write", ByteBuffer[].class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.d(TAG, "afterHookedMethod: ");
                Log.d(TAG,"write堆栈调用： "+Log.getStackTraceString(new Throwable()));
            }
        });



        findAndHookMethod(aClass, "connect", SocketAddress.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(TAG, "hookSocketChannel connect beforeHookedMethod ");
                InetSocketAddress address = (InetSocketAddress) param.args[0];
                Log.d(TAG,"param1 host: "+address.getHostName()+"  port: "+address.getPort());
                Log.d(TAG,"connect堆栈调用： "+Log.getStackTraceString(new Throwable()));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.d(TAG, "hookSocketChannel connect afterHookedMethod ");
            }
        });

        findAndHookMethod(aClass, "open", SocketAddress.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(TAG, "hookSocketChannel open beforeHookedMethod ");
                InetSocketAddress address = (InetSocketAddress) param.args[0];
                Log.d(TAG,"param1 host: "+address.getHostName()+"  port: "+address.getPort());
                Log.d(TAG,"open堆栈调用： "+Log.getStackTraceString(new Throwable()));
            }
        });


    }




    private void hookNetwork(XC_LoadPackage.LoadPackageParam lpparam) {


        //网络监控开始
        if(NETWORK) {
            findAndHookConstructor(InetSocketAddress.class, String.class, int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param)
                        throws Throwable {
                    Log.d(TAG, "InetSocketAddress 网络地址: " + param.args[0] + ":" + param.args[1]);
//                    Log.d(TAG,"InetSocketAddress堆栈调用： "+Log.getStackTraceString(new Throwable()));
                    super.beforeHookedMethod(param);
                }
            });


            findAndHookMethod("java.net.InetSocketAddress", lpparam.classLoader,
                    "createUnresolved", String.class, int.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Log.d(TAG, "InetSocketAddress createUnresolved-- host: " + param.args[0]+" port:"+param.args[1]);
//                            Log.d(TAG,"createUnresolved堆栈调用： "+Log.getStackTraceString(new Throwable()));
                            super.beforeHookedMethod(param);
                        }
                    });

            findAndHookMethod("java.nio.ByteBuffer", lpparam.classLoader, "wrap", byte[].class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            byte[] bytes = (byte[]) param.args[0];
                            Log.d(TAG, "beforeHookedMethod ByteBuffer.wrap调用 : "+Arrays.toString(bytes));
//                            Log.d(TAG,"ByteBuffer.wrap堆栈调用： "+Log.getStackTraceString(new Throwable()));

                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            ByteBuffer buffer = (ByteBuffer) param.getResult();
                            byte[] array = buffer.array();
                            Log.d(TAG, "afterHookedMethod ByteBuffer.wrap调用 : "+Arrays.toString(array));
                            super.afterHookedMethod(param);
                        }
                    });
            findAndHookMethod("java.nio.channels.SocketChannel", lpparam.classLoader, "read", ByteBuffer.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            ByteBuffer buffer = (ByteBuffer) param.args[0];
                            byte[] array = buffer.array();
                            Log.d(TAG, "read调用 buffer数据: "+Arrays.toString(array));
                            Log.d(TAG,"read堆栈调用： "+Log.getStackTraceString(new Throwable()));
                            super.beforeHookedMethod(param);
                        }
                    });

//            findAndHookMethod("java.nio.channels.SocketChannel", lpparam.classLoader, "write",
////                    ByteBuffer[].class,
////                    new XC_MethodHook() {
////                        @Override
////                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////
////                            Log.d(TAG,"SocketChannel write堆栈调用： "+Log.getStackTraceString(new Throwable()));
////                            super.beforeHookedMethod(param);
////                        }
////                    });
////
////            findAndHookMethod("java.nio.channels.SocketChannel", lpparam.classLoader, "open", SocketAddress.class, new XC_MethodHook() {
////                @Override
////                protected void beforeHookedMethod(MethodHookParam param)
////                        throws Throwable {
////                    Log.d(TAG, "SocketChannel open: tcp连接 " + ((SocketAddress) param.args[0]).toString());
////                    Log.d(TAG,"SocketChannel open堆栈调用： "+Log.getStackTraceString(new Throwable()));
////                    super.beforeHookedMethod(param);
////                }
////            });


//
//            //
//            if (SOCKET_DATA) {
//                findAndHookMethod("java.io.OutputStream", lpparam.classLoader, "write", byte[].class, int.class, int.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param)
//                            throws Throwable {
//                        byte[] d = (byte[]) param.args[0];
//                        Log.d(TAG, "OutputStream write(byte[],int,int) String:" + new String(d));
//                        Log.d(TAG, "OutputStream write byte:" + Arrays.toString(d));
//                        Log.d(TAG,"OutputStream堆栈调用： "+Log.getStackTraceString(new Throwable()));
//                        super.beforeHookedMethod(param);
//                    }
//                });
//                findAndHookMethod("java.io.OutputStream", lpparam.classLoader, "write", byte[].class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param)
//                            throws Throwable {
//                        byte[] d = (byte[]) param.args[0];
//                        Log.d(TAG, "OutputStream write(byte[]): " + new String(d));
//                        Log.d(TAG,"OutputStream堆栈调用： "+Log.getStackTraceString(new Throwable()));
//                        super.beforeHookedMethod(param);
//                    }
//                });
//            }
//            findAndHookMethod("java.nio.channels.SocketChannel", lpparam.classLoader, "connect", SocketAddress.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//
//                    Log.d(TAG,"SocketChannel connect堆栈调用： "+Log.getStackTraceString(new Throwable()));
//                    super.beforeHookedMethod(param);
//                }
//            });




//            findAndHookMethod("java.net.Socket", lpparam.classLoader, "startupSocket", InetAddress.class, int.class, InetAddress.class, int.class, boolean.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param)
//                        throws Throwable {
//                    Log.d(TAG, "Socket startupSocket tcp连接:" + ((InetAddress) param.args[0]).toString() + ":" + (Integer) param.args[1]);
//                    super.beforeHookedMethod(param);
//                }
//            });
//            findAndHookMethod("java.net.Socket", lpparam.classLoader, "connect", SocketAddress.class, int.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param)
//                        throws Throwable {
//                    Log.d(TAG, "java.net.Socket connect tcp连接: " + ((SocketAddress) param.args[0]).toString());
//                    super.beforeHookedMethod(param);
//                }
//            });

        }
    }



}
