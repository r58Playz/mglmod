#version 460

layout(location = 0) in vec3 Position;
layout(location = 1) in vec2 UV0;

layout(location = 0) uniform mat4 ModelViewMat;
layout(location = 1) uniform mat4 ProjMat;

layout(location = 2) out vec2 texCoord0;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    texCoord0 = UV0;
}
