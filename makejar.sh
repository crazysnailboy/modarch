MOD_NAME=modarch
mkdir tmp
cp mcmod.info tmp
cp -r $MC_FORGE_1_4_7_HOME/mcp/reobf/minecraft/com tmp
cp src/com/madebyhq/$MOD_NAME/*.png tmp/com/madebyhq/$MOD_NAME
cd tmp
jar cf ../bin/$MOD_NAME.jar .
cd  ..
rm -rf tmp