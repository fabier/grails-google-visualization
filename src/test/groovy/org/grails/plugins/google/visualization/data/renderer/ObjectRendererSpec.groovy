/* Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.google.visualization.data.renderer

import spock.lang.Specification

/**
 * Object renderer tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class ObjectRendererSpec extends Specification {
    void testRenderValue() {
        expect:
        ObjectRenderer.instance.renderValue(new Expando(stroke: 'black', fill: '#eee', strokeSize: 1)).toString() == "{stroke: 'black', fill: '#eee', strokeSize: 1}"
    }

    void testRenderValueRealObject() {
        setup:
        def simpleObject = new SimpleClass(a: "xxx", b: 123)
        when:
        def renderedObject = ObjectRenderer.instance.renderValue(simpleObject)
        then:
        renderedObject.toString() == "{b: 123, a: 'xxx'}"
    }

    class SimpleClass {
        String a
        int b
    }
}
