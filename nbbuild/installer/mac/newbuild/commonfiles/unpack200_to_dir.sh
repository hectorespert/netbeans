#!/bin/sh

#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#

unpack_dir="$1"
tmp_dir="$2"
jdk_home="$3"

if [ ! -d "$tmp_dir" ] ; then
    mkdir -p "$tmp_dir"
fi

javapath=`/usr/libexec/java_home --version 1.8`
echo Calling unpack200 in "$unpack_dir". Saving result in "$tmp_dir"
cd "$unpack_dir"
for x in `find . -name \*.jar.pack` ; do
    jar_subpath=`echo $x | sed 's/jar.pack/jar/;s/^.\///'`
    jar="$tmp_dir"/"$jar_subpath"   
    mkdir -p `dirname "$jar"`
    echo "Unpack file $x into $tmp_dir / $jar_subpath"
    $javapath/bin/unpack200 "$x" "$jar"
done

exit 0
