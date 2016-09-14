/*
 * Copyright (C) 2015-2016 Samuel Audet
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Adapter;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.annotation.StdString;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Samuel Audet
 */
@Properties(value = @Platform(
        value = {"linux-x86", "macosx"},
        compiler = "cpp11",
        define = {"NDEBUG", "UNIQUE_PTR_NAMESPACE std"},
        include = {
        "tensorflow/core/platform/default/integral_types.h",
        "tensorflow/core/framework/numeric_types.h",
        "tensorflow/core/platform/init_main.h",
        "tensorflow/core/platform/types.h",
        "tensorflow/core/platform/mutex.h",
        "tensorflow/core/platform/macros.h",
        "tensorflow/core/util/port.h",
        "tensorflow/core/lib/core/error_codes.pb.h",
        "tensorflow/core/platform/logging.h",
        "tensorflow/core/lib/core/status.h",
        "tensorflow/core/platform/protobuf.h",
        "tensorflow/core/platform/file_system.h",
        "tensorflow/core/platform/file_statistics.h",
        "tensorflow/core/platform/env.h",
        "tensorflow/core/graph/dot.h",
        "tensorflow/core/protobuf/config.pb.h",
        "tensorflow/core/framework/cost_graph.pb.h",
        "tensorflow/core/framework/step_stats.pb.h",
        "tensorflow/core/framework/versions.pb.h",
        "tensorflow/core/public/session_options.h",
        "tensorflow/core/lib/core/threadpool.h",
        "tensorflow/core/framework/allocation_description.pb.h",
        "tensorflow/core/framework/allocator.h",
        "tensorflow/core/framework/tensor_shape.pb.h",
        "tensorflow/core/framework/types.pb.h",
        "tensorflow/core/framework/tensor.pb.h",
        "tensorflow/core/framework/tensor_description.pb.h",
        "tensorflow/core/framework/tensor_types.h",
        "tensorflow/core/framework/tensor_shape.h",
//        "tensorflow/core/framework/tensor_slice.h",
        "tensorflow/core/framework/tensor_util.h",
        "tensorflow/core/framework/tensor_reference.h",
        "tensorflow/core/framework/tensor.h",
        "tensorflow/core/framework/attr_value.pb.h",
        "tensorflow/core/framework/op_def.pb.h",
        "tensorflow/core/framework/function.pb.h",
        "tensorflow/core/framework/graph.pb.h",
        "tensorflow/core/framework/shape_inference.h",
        "tensorflow/core/framework/partial_tensor_shape.h",
        "tensorflow/core/public/session.h",
        "tensorflow/c/c_api.h",
        "tensorflow/core/framework/op_def.pb.h",
        "tensorflow/core/framework/op_def_builder.h",
        "tensorflow/core/framework/op_def_util.h",
        "tensorflow/core/framework/op.h",
        "tensorflow/core/framework/types.h",
        "tensorflow/core/graph/edgeset.h",
        "tensorflow/core/lib/gtl/iterator_range.h",
//        "tensorflow/core/lib/gtl/inlined_vector.h",
        "tensorflow/core/graph/graph.h",
        "tensorflow/core/framework/node_def_builder.h",
        "tensorflow/core/framework/node_def_util.h",
        "tensorflow/core/graph/node_builder.h",
        "tensorflow/core/graph/graph_def_builder.h",
        "tensorflow/core/graph/default_device.h",
        "tensorflow/core/graph/graph_constructor.h",
        "tensorflow/cc/framework/scope.h",
        "tensorflow/cc/framework/ops.h",
        "tensorflow/cc/framework/cc_op_gen.h",
        "tensorflow/core/ops/array_grad.cc",
        "tensorflow/core/ops/array_ops.cc",
        "tensorflow/core/ops/candidate_sampling_ops.cc",
        "tensorflow/core/ops/control_flow_ops.cc",
        "tensorflow/core/ops/ctc_ops.cc",
        "tensorflow/core/ops/data_flow_ops.cc",
        "tensorflow/core/ops/function_ops.cc",
        "tensorflow/core/ops/functional_grad.cc",
        "tensorflow/core/ops/functional_ops.cc",
        "tensorflow/core/ops/image_ops.cc",
        "tensorflow/core/ops/io_ops.cc",
        "tensorflow/core/ops/linalg_ops.cc",
        "tensorflow/core/ops/logging_ops.cc",
//        "tensorflow/core/ops/math_grad.cc",
//        "tensorflow/core/ops/math_ops.cc",
        "tensorflow/core/ops/nn_grad.cc",
        "tensorflow/core/ops/nn_ops.cc",
        "tensorflow/core/ops/parsing_ops.cc",
        "tensorflow/core/ops/random_grad.cc",
        "tensorflow/core/ops/random_ops.cc",
        "tensorflow/core/ops/script_ops.cc",
        "tensorflow/core/ops/sendrecv_ops.cc",
        "tensorflow/core/ops/sparse_ops.cc",
        "tensorflow/core/ops/state_ops.cc",
        "tensorflow/core/ops/string_ops.cc",
        "tensorflow/core/ops/training_ops.cc",
        "tensorflow_adapters.h"},
        link = "tensorflow"),
        target = "org.bytedeco.javacpp.tensorflow",
        helper = "org.bytedeco.javacpp.helper.tensorflow")
public class tensorflow implements InfoMapper {
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("tensorflow_adapters.h").skip())
               .put(new Info("const_op.h").skip())
               .put(new Info("math_ops.h").skip())
               .put(new Info("array_ops.h").skip())
               .put(new Info("TF_FALLTHROUGH_INTENDED", "TF_ATTRIBUTE_NORETURN", "TF_ATTRIBUTE_NOINLINE",
                             "TF_ATTRIBUTE_UNUSED", "TF_ATTRIBUTE_COLD", "TF_PACKED", "TF_MUST_USE_RESULT", "__COUNTER__").cppTypes().annotations())
               .put(new Info("TF_CHECK_OK", "TF_QCHECK_OK").cppTypes("void", "tensorflow::Status"))
               .put(new Info("TF_DISALLOW_COPY_AND_ASSIGN").cppText("#define TF_DISALLOW_COPY_AND_ASSIGN(TypeName)"))
               .put(new Info("PROTOBUF_DEPRECATED_ATTR").cppTypes().annotations("@Deprecated"))
               .put(new Info("SWIG").define())
               .put(new Info("Eigen::half").cast().valueTypes("short").pointerTypes("ShortPointer", "ShortBuffer", "short..."))
               .put(new Info("short", "tensorflow::int16", "tensorflow::uint16").valueTypes("short").pointerTypes("ShortPointer", "ShortBuffer", "short..."))
               .put(new Info("int", "int32", "tensorflow::int32", "tensorflow::uint32").valueTypes("int").pointerTypes("IntPointer", "IntBuffer", "int..."))
               .put(new Info("long long", "tensorflow::int64", "tensorflow::uint64").cast().valueTypes("long").pointerTypes("LongPointer", "LongBuffer", "long..."))
               .put(new Info("float").valueTypes("float").pointerTypes("FloatPointer", "FloatBuffer", "float..."))
               .put(new Info("double").valueTypes("double").pointerTypes("DoublePointer", "DoubleBuffer", "double..."))
               .put(new Info("bool").cast().valueTypes("boolean").pointerTypes("BoolPointer", "boolean..."))
               .put(new Info("std::complex<float>").cast().pointerTypes("FloatPointer", "FloatBuffer", "float..."))
               .put(new Info("std::initializer_list").skip())
               .put(new Info("std::string").annotations("@StdString").valueTypes("BytePointer", "String").pointerTypes("@Cast({\"char*\", \"std::string*\"}) BytePointer"))
               .put(new Info("std::vector<std::string>").pointerTypes("StringVector").define())
               .put(new Info("std::condition_variable", "std::mutex", "std::unique_lock<std::mutex>", "tensorflow::condition_variable", "tensorflow::mutex_lock").cast().pointerTypes("Pointer"))

               .put(new Info("google::protobuf::int8", "google::protobuf::uint8").cast().valueTypes("byte").pointerTypes("BytePointer", "ByteBuffer", "byte[]"))
               .put(new Info("google::protobuf::int16", "google::protobuf::uint16").cast().valueTypes("short").pointerTypes("ShortPointer", "ShortBuffer", "short[]"))
               .put(new Info("google::protobuf::int32", "google::protobuf::uint32").cast().valueTypes("int").pointerTypes("IntPointer", "IntBuffer", "int[]"))
               .put(new Info("google::protobuf::int64", "google::protobuf::uint64").cast().valueTypes("long").pointerTypes("LongPointer", "LongBuffer", "long[]"))
               .put(new Info("google::protobuf::Arena", "google::protobuf::Descriptor", "google::protobuf::EnumDescriptor", "google::protobuf::Message",
                             "google::protobuf::Metadata", "google::protobuf::io::CodedInputStream", "google::protobuf::io::CodedOutputStream").cast().pointerTypes("Pointer"))
               .put(new Info("google::protobuf::Map", "google::protobuf::RepeatedField", "google::protobuf::RepeatedPtrField").skip())

               .put(new Info("tensorflow::core::RefCounted").cast().pointerTypes("Pointer"))
               .put(new Info("tensorflow::ConditionResult").cast().valueTypes("int"))
               .put(new Info("tensorflow::protobuf::Message", "tensorflow::protobuf::MessageLite").cast().pointerTypes("Pointer"))
               .put(new Info("tensorflow::Allocator::is_simple<bfloat16>").skip())

               .put(new Info("basic/containers").cppTypes("tensorflow::gtl::InlinedVector", "google::protobuf::Map"))
               .put(new Info("tensorflow::DataType").cast().valueTypes("int").pointerTypes("IntPointer"))
               .put(new Info("tensorflow::gtl::InlinedVector<tensorflow::int64,4>").pointerTypes("LongVector").define())
               .put(new Info("tensorflow::gtl::InlinedVector<tensorflow::DataType,4>").pointerTypes("DataTypeVector").define())
               .put(new Info("tensorflow::DataTypeSlice").cast().pointerTypes("DataTypeVector"))

               .put(new Info("tensorflow::Tensor").base("AbstractTensor"))
               .put(new Info("tensorflow::Session").base("AbstractSession"))
               .put(new Info("tensorflow::Session::~Session()").javaText("/** Calls {@link tensorflow#NewSession(SessionOptions)} and registers a deallocator. */\n"
                                                                       + "public Session(SessionOptions options) { super(options); }"))
               .put(new Info("std::vector<tensorflow::Tensor>").pointerTypes("TensorVector").define())
               .put(new Info("std::vector<tensorflow::TensorProto>").pointerTypes("TensorProtoVector").define())
               .put(new Info("std::vector<tensorflow::TensorShape>").pointerTypes("TensorShapeVector").define())
               .put(new Info("std::vector<tensorflow::NodeBuilder::NodeOut>").pointerTypes("NodeOutVector").define())
               .put(new Info("std::vector<tensorflow::Node*>").pointerTypes("NodeVector").define())
               .put(new Info("google::protobuf::Map<std::string,tensorflow::AttrValue>").pointerTypes("StringAttrValueMap").define())
               .put(new Info("tensorflow::ops::NodeOut").valueTypes("@ByVal NodeBuilder.NodeOut", "Node"))
               .put(new Info("tensorflow::NodeBuilder::NodeOut").pointerTypes("NodeBuilder.NodeOut"))

               .put(new Info("tensorflow::Scope").pointerTypes("Scope"))
               .put(new Info("std::vector<tensorflow::ops::Input>").pointerTypes("InputVector"))
               .put(new Info("std::vector<tensorflow::ops::Input>::iterator").skip())
               .put(new Info("std::vector<tensorflow::ops::Input>::const_iterator").skip())
               .put(new Info("tensorflow::ops::Cast").pointerTypes("CastOp"))
               .put(new Info("tensorflow::ops::Const").pointerTypes("ConstOp"))
               .put(new Info("mode_t").skip())

               .put(new Info("tensorflow::gtl::ArraySlice<std::string>").cast().pointerTypes("StringVector"))
               .put(new Info("tensorflow::gtl::ArraySlice<tensorflow::Tensor>")/*.cast()*/.pointerTypes("TensorVector"))
               .put(new Info("tensorflow::gtl::ArraySlice<tensorflow::TensorProto>")/*.cast()*/.pointerTypes("TensorProtoVector"))
               .put(new Info("tensorflow::gtl::ArraySlice<tensorflow::TensorShape>").cast().pointerTypes("TensorShapeVector"))
               .put(new Info("tensorflow::gtl::ArraySlice<tensorflow::ops::NodeOut>")/*.cast()*/.pointerTypes("NodeOutVector"))
               .put(new Info("tensorflow::gtl::ArraySlice<tensorflow::Node*>")/*.cast()*/.pointerTypes("NodeVector"))
               .put(new Info("tensorflow::gtl::iterator_range<tensorflow::NeighborIter>").pointerTypes("NeighborIterRange").define())
               .put(new Info("tensorflow::gtl::iterator_range<tensorflow::NeighborIter>()").skip())
               .put(new Info("tensorflow::gtl::iterator_range<tensorflow::NodeIter>").pointerTypes("NodeIterRange").define())
               .put(new Info("tensorflow::gtl::iterator_range<tensorflow::NodeIter>()").skip())

                .put(new Info("std::unordered_map<std::string,std::pair<int,int> >").pointerTypes("NameRangeMap").define())

                // Skip composite op scopes bc: call to implicitly-deleted default constructor of '::tensorflow::CompositeOpScopes'
               .put(new Info("tensorflow::CompositeOpScopes").skip())

                //cannot find symbol
                //symbol:   class ShapeInferenceFn
                //location: class org.bytedeco.javacpp.tensorflow.OpRegistrationData
               .put(new Info("std::function<tensorflow::Status(tensorflow::shape_inference::InferenceContext*)>").pointerTypes("ShapeInferenceFn"))
               .put(new Info("tensorflow::OpShapeInferenceFn").skip())

                // cannot find symbol
                // [ERROR] symbol:   class Factory
                // [ERROR] location: class org.bytedeco.javacpp.tensorflow.Env
               .put(new Info("tensorflow::RegisterFileSystem").skip())
               .put(new Info("tensorflow::EnvWrapper::RegisterFileSystem").skip())
               .put(new Info("tensorflow::FileSystemRegistry").skip())
               .put(new Info("tensorflow::Factory").pointerTypes("Factory"))

                // cannot find symbol
                // [ERROR] symbol:   class FakeInputFunctor
                // [ERROR] location: class org.bytedeco.javacpp.tensorflow.NodeDefBuilder
               .put(new Info("std::function<tensorflow::Status(const tensorflow::OpDef&, int, const tensorflow::NodeDef&, tensorflow::NodeDefBuilder*)>").skip())
               .put(new Info("tensorflow::FakeInputFunctor").skip())

                // cannot find symbol
                // [ERROR] symbol:   class OpRegistrationDataFactory
                // [ERROR] location: class org.bytedeco.javacpp.tensorflow.OpRegistry
                .put(new Info("tensorflow::OpRegistrationDataFactory").skip())
                .put(new Info("std::function<tensorflow::Status(tensorflow::OpRegistrationData*)>").skip())

                .put(new Info("tensorflow::Watcher").skip())
                .put(new Info("std::function<tensorflow::Status(const tensorflow::Status&, const OpDef&)>").pointerTypes("WatcherFn"))

                // no member named 'register_op__COUNTER__' in namespace 'tensorflow'
                // rptr = &tensorflow::register_op__COUNTER__;
                .put(new Info("tensorflow::register_op::OpDefBuilderReceiver").skip())

                // Fixed shape inference
                .put(new Info("std::vector<const tensorflow::Tensor*>").pointerTypes("ConstTensorPtrVector").define())
                .put(new Info("std::vector<const tensorflow::shape_inference::Dimension*>").pointerTypes("ConstDimensionPtrVector").define())

               .put(new Info("std::vector<std::pair<std::string,tensorflow::Tensor> >").pointerTypes("StringTensorPairVector").define())
               .put(new Info("std::pair<tensorflow::EdgeSet::iterator,bool>").pointerTypes("EdgeSetBoolPair").define())
               .put(new Info("tensorflow::EdgeSet::const_iterator", "tensorflow::EdgeSet::iterator").pointerTypes("EdgeSetIterator"))

               .put(new Info("tensorflow::register_op::OpDefBuilderWrapper<true>").pointerTypes("TrueOpDefBuilderWrapper"))
               .put(new Info("tensorflow::register_op::OpDefBuilderWrapper<false>").pointerTypes("FalseOpDefBuilderWrapper"))

               .put(new Info("protobuf::Map<std::string,tensorflow::AttrValue>").pointerTypes("StringAttrValueMap"))

               .put(new Info("std::function<void()>").pointerTypes("Fn"))
               .put(new Info("std::function<void(int64,int64)>").pointerTypes("ForFn"))
               .put(new Info("tensorflow::ConstantFoldingOptions::consider")
                       .javaText("@MemberSetter public native ConstantFoldingOptions consider(@ByVal ConsiderFunction consider);"))
               .put(new Info("tensorflow::GraphConstructorOptions::cse_consider_function")
                       .javaText("@MemberSetter public native GraphConstructorOptions cse_consider_function(@ByVal ConsiderFunction cse_consider_function);"));

        String[] attrs = {"int", "long long", "float", "double", "bool", "std::string",
                          "tensorflow::Tensor", "tensorflow::TensorProto", "tensorflow::TensorShape",
                          "tensorflow::NameAttrList", "tensorflow::StringPiece"};
        for (int i = 0; i < attrs.length; i++) {
            infoMap.put(new Info("tensorflow::GraphDefBuilder::Options::WithAttr<" + attrs[i] + ">").javaNames("WithAttr"));
            if (i < attrs.length - 2) {
                infoMap.put(new Info("tensorflow::GraphDefBuilder::Options::WithAttr<tensorflow::gtl::ArraySlice<" + attrs[i] + "> >").javaNames("WithAttr"));
            }
        }

        infoMap.put(new Info("tensorflow::DotOptions::edge_label")
                       .javaText("@MemberSetter public native DotOptions edge_label(EdgeLabelFunction edge_label_function);"))
               .put(new Info("tensorflow::DotOptions::node_label")
                       .javaText("@MemberSetter public native DotOptions node_label(NodeLabelFunction node_label_function);"))
               .put(new Info("tensorflow::DotOptions::edge_cost")
                        .javaText("@MemberSetter public native DotOptions edge_cost(EdgeCostFunction edge_cost_function);"))
               .put(new Info("tensorflow::DotOptions::node_cost")
                       .javaText("@MemberSetter public native DotOptions node_cost(NodeCostFunction node_cost_function);"))
               .put(new Info("tensorflow::DotOptions::node_color")
                       .javaText("@MemberSetter public native DotOptions node_color(NodeColorFunction node_color_function);"))

               .put(new Info("std::function<double(const *tensorflow::Edge)>").pointerTypes("EdgeCostFunction"))
               .put(new Info("std::function<double(const *tensorflow::Node)>").pointerTypes("NodeCostFunction"))
               .put(new Info("std::function<std::string(const *tensorflow::Node)>").pointerTypes("NodeLabelFunction"))
               .put(new Info("std::function<std::string(const *tensorflow::Edge)>").pointerTypes("EdgeLabelFunction"))
               .put(new Info("std::function<int(const *tensorflow::Node)>").pointerTypes("NodeColorFunction"));

        infoMap.put(new Info("tensorflow::gtl::ArraySlice").annotations("@ArraySlice"))
               .put(new Info("tensorflow::StringPiece").annotations("@StringPiece").valueTypes("BytePointer", "String").pointerTypes("BytePointer"))
               .put(new Info("tensorflow::ops::Const(tensorflow::StringPiece, tensorflow::GraphDefBuilder::Options&)")
                       .javaText("@Namespace(\"tensorflow::ops\") public static native Node Const("
                               + "@Cast({\"\", \"tensorflow::StringPiece&\"}) @StringPiece String s, @Const @ByRef GraphDefBuilder.Options options);"));
    }

    public static class Fn extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Fn(Pointer p) { super(p); }
        protected Fn() { allocate(); }
        private native void allocate();
        public native void call();
    }

    public static class ForFn extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    ForFn(Pointer p) { super(p); }
        protected ForFn() { allocate(); }
        private native void allocate();
        public native void call(long from, long to);
    }

    public static class ConsiderFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    ConsiderFunction(Pointer p) { super(p); }
        protected ConsiderFunction() { allocate(); }
        private native void allocate();
        public native @Cast("bool") boolean call(@Cast("const tensorflow::Node*") Pointer node);
    }

    public static class NodeColorFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    NodeColorFunction(Pointer p) { super(p); }
        protected NodeColorFunction() { allocate(); }
        private native void allocate();
        public native @Cast("int") int call(@Cast("const tensorflow::Node*") Pointer node);
    }

    public static class NodeCostFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    NodeCostFunction(Pointer p) { super(p); }
        protected NodeCostFunction() { allocate(); }
        private native void allocate();
        public native @Cast("double") double call(@Cast("const tensorflow::Node*") Pointer node);
    }

   public static class EdgeCostFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    EdgeCostFunction(Pointer p) { super(p); }
        protected EdgeCostFunction() { allocate(); }
        private native void allocate();
        public native @Cast("double") double call(@Cast("const tensorflow::Edge*") Pointer node);
    }

    public static class NodeLabelFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    NodeLabelFunction(Pointer p) { super(p); }
        protected NodeLabelFunction() { allocate(); }
        private native void allocate();
        public native @StdString BytePointer call(@Cast("const tensorflow::Node*") Pointer node);
    }

    public static class EdgeLabelFunction extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    EdgeLabelFunction(Pointer p) { super(p); }
        protected EdgeLabelFunction() { allocate(); }
        private native void allocate();
        public native @StdString BytePointer call(@Cast("const tensorflow::Edge*") Pointer node);
    }

    @Documented @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.PARAMETER})
    @Cast({"tensorflow::gtl::ArraySlice", "&"}) @Adapter("ArraySliceAdapter")
    public @interface ArraySlice { String value() default ""; }

    @Documented @Retention(RetentionPolicy.RUNTIME)
    @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
    @Adapter("StringPieceAdapter")
    public @interface StringPiece { }
}
