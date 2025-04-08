/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.theillusivec4.curios.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.util.IIconHelper;

public class IconHelper implements IIconHelper {

  private Map<String, ResourceLocation> idToIcon = new HashMap<>();

  @Override
  public void clearIcons() {
    this.idToIcon.clear();
  }

  @Override
  public void addIcon(String identifier, ResourceLocation resourceLocation) {
    this.idToIcon.putIfAbsent(identifier, resourceLocation);
  }

  @Override
  public ResourceLocation getIcon(String identifier) {
    return idToIcon.getOrDefault(identifier, new ResourceLocation(CuriosApi.MODID, "slot/empty_curio_slot"));
  }
}
