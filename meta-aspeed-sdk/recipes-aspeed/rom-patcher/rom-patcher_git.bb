SUMMARY = "Aspeed ROM-patch image generator"
HOMEPAGE = "https://github.com/AspeedTech-BMC/rom-patcher"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/AspeedTech-BMC/rom-patcher/;protocol=https;branch=${BRANCH} \
           file://meson.build \
          "

PV = "1.0+git${SRCPV}"

# Tag for v00.01.00
SRCREV = "52ce86d617b77234e84d11873ab85136f63ca529"
BRANCH = "main"

S = "${WORKDIR}/git"

inherit meson

do_configure:prepend() {
    cp ${WORKDIR}/meson.build ${S}
}

do_install:append() {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 644 ${S}/zephyr.bin ${DEPLOY_DIR_IMAGE}
}

BBCLASSEXTEND = "native nativesdk"
