#version 460

uniform sampler2D DiffuseSampler;

uniform vec4 ColorModulate;

in vec2 texCoord;

out vec4 fragColor;

void main(){
    fragColor = texture(DiffuseSampler, texCoord) * ColorModulate;
}
