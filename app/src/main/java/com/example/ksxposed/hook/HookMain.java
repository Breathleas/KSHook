package com.example.ksxposed.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.ksxposed.util.Utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.example.ksxposed.config.Config.KS_PackageName;
import static com.example.ksxposed.config.Config.TAG;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

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

    /**
     *
     * @param classLoader
     */
    private void hook(final ClassLoader classLoader){
            try {
                Class<?> aClass = classLoader.loadClass("z.b.b.z");
                //
//                findAndHookMethod(aClass, "a", int.class,
//                        ScatteringByteChannel.class, int.class, new XC_MethodHook() {
//                            @Override
//                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                                super.beforeHookedMethod(param);
////                                Log.d(TAG,"z.b.b.z-->a堆栈调用： "+Log.getStackTraceString(new Throwable()));
//                            }
//
//                            @Override
//                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                                super.afterHookedMethod(param);
//                                int i1 = (int) param.args[0];
//                                int i2 = (int) param.args[2];
//
//
//                                ScatteringByteChannel channel = (ScatteringByteChannel) param.args[1];
//                                ByteBuffer buf = ByteBuffer.allocate(512);
//
//                                int read = channel.read(buf);
//                                byte[] array = buf.array();
//                                Log.d(TAG, "z.b.b.z->a  i1: "+i1+" i2:"+i2+"\n"+
//                                        "z.b.b.z->a buffer字节: "+Arrays.toString(array)+"\n"+
//                                        "z.b.b.z->a buffer 16进制: "+ Utils.bytesToHexString(array)
//                                );
//                            }
//                        });
//
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
//                                "z.b.b.z->b: byte[] "+Arrays.toString(bytes)+"\n"+
//                                "z.b.b.z->b: byte[]16进制 "+Utils.bytesToHexString(bytes)
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


        /**
         *  hook z.b.c.w0.e.b-->a
         *
         *  public void mo119323a(C76588s sVar) throws Exception {

         *  public final class C76588s --- z.b.c.s
         */
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


        /**
         * z.b.f.p.l -> a
         */
        try {
            Class<?> lClass = classLoader.loadClass("z.b.f.p.l");
            Class<?> fClass = XposedHelpers.findClass("z.b.f.q.f",classLoader);
            findAndHookMethod(lClass, "a", fClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object result = param.getResult();
                    if (result instanceof ByteBuffer[]){
                        ByteBuffer[] a2 = (ByteBuffer[]) result;
                        if (a2 == null){
                            Log.d(TAG, "z.b.f.p.l->a: a2为空 ");
                            return;
                        }
                        int length = a2.length;

                        synchronized (this){
                            for (int i = 0; i < length; i++) {
                                ByteBuffer buffers = a2[i];
                                byte[] array = buffers.array();
                                if (array == null){
                                    Log.d(TAG, "z.b.f.p.l->a: array为空 ; i == "+i);
                                    return;
                                }
                                Log.d(TAG, "z.b.f.p.l->a: 获取a2 ByteBuffer i: "+i+" buffer16进制: "+Utils.bytesToHexString(array));
                            }
                        }
                    }

                }
            });

            /**
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
                    ByteBuffer[] buffer = (ByteBuffer[]) param.getResult();
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "hook: z.b.f.p.l未找到");
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
