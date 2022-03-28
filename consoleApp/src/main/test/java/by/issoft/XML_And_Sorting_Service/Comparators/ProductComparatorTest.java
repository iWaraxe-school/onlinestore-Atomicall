package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import by.issoft.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.*;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductComparatorTest {
    /*Comparator<Product> c = Mockito.mock(NameComparator.class);
    java.lang.ExceptionInInitializerError
    at org.mockito.cglib.core.KeyFactory$Generator.generateClass(KeyFactory.java:167)
    at org.mockito.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
    at org.mockito.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:217)
    at org.mockito.cglib.core.KeyFactory$Generator.create(KeyFactory.java:145)
    at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:117)
    at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:109)
    at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:105)
    at org.mockito.cglib.proxy.Enhancer.<clinit>(Enhancer.java:70)
    at org.mockito.internal.creation.cglib.ClassImposterizer.createProxyClass(ClassImposterizer.java:95)
    at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:57)
    at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:49)
    at org.mockito.internal.creation.cglib.CglibMockMaker.createMock(CglibMockMaker.java:24)
    at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:33)
    at org.mockito.internal.MockitoCore.mock(MockitoCore.java:59)
    at org.mockito.Mockito.mock(Mockito.java:1284)
    at org.mockito.Mockito.mock(Mockito.java:1162)
    at consoleApp/by.issoft.XML_And_Sorting_Service.Comparators.ProductComparatorTest.<init>(ProductComparatorTest.java:21)
    at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
    at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:78)
    at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
    at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
    at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
    at org.junit.platform.commons.util.ReflectionUtils.newInstance(ReflectionUtils.java:550)
    at org.junit.jupiter.engine.execution.ConstructorInvocation.proceed(ConstructorInvocation.java:56)
    at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
    at org.junit.jupiter.api.extension.InvocationInterceptor.interceptTestClassConstructor(InvocationInterceptor.java:73)
    at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
    at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
    at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
    at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
    at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
    at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
    at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:77)
    at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestClassConstructor(ClassBasedTestDescriptor.java:355)
    at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateTestClass(ClassBasedTestDescriptor.java:302)
    at org.junit.jupiter.engine.descriptor.ClassTestDescriptor.instantiateTestClass(ClassTestDescriptor.java:79)
    at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:280)
    at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$4(ClassBasedTestDescriptor.java:272)
    at java.base/java.util.Optional.orElseGet(Optional.java:364)
    at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$5(ClassBasedTestDescriptor.java:271)
    at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31)
    at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:102)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:101)
    at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:66)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$2(NodeTestTask.java:123)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:123)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:90)
    at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
    at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
    at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
    at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
    at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
    at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
    at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
    at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
    at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54)
    at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:107)
    at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
    at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
    at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
    at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
    at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
    at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:86)
    at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:86)
    at org.junit.platform.launcher.core.SessionPerRequestLauncher.execute(SessionPerRequestLauncher.java:53)
    at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71)
    at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
    at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:220)
    at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:53)
    Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @69a10787
    at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:357)
    at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
    at java.base/java.lang.reflect.Method.checkCanSetAccessible(Method.java:199)
    at java.base/java.lang.reflect.Method.setAccessible(Method.java:193)
    at org.mockito.cglib.core.ReflectUtils$2.run(ReflectUtils.java:57)
    at java.base/java.security.AccessController.doPrivileged(AccessController.java:312)
    at org.mockito.cglib.core.ReflectUtils.<clinit>(ReflectUtils.java:47)
            ... 85 more*/ // Mockito сообщение об ошибке
    @Test
    void getComparatorFor() {
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.NAME, SortingTypes.ASC).getClass(),
                NameComparator.class);
        Comparator<Product> comparator = new NameComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.NAME, SortingTypes.DESC).getClass(),
               comparator.getClass());
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.RATE, SortingTypes.ASC).getClass(),
                RateComparator.class);
        comparator = new RateComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.RATE, SortingTypes.DESC).getClass(),
                comparator.getClass());
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.PRICE, SortingTypes.ASC).getClass(),
                PriceComparator.class);
        comparator = new PriceComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.PRICE, SortingTypes.DESC).getClass(),
                comparator.getClass());

    }
}