import request from '@/utils/request'
//查询所有站点
export function listAllSite() {
  return request({
    url: '/system/site/listAll',
    method: 'POST',
  })
}

// 查询垃圾站点管理列表
export function listSite(query) {
  return request({
    url: '/system/site/list',
    method: 'get',
    params: query
  })
}

// 查询垃圾站点管理详细
export function getSite(id) {
  return request({
    url: '/system/site/' + id,
    method: 'get'
  })
}

// 新增垃圾站点管理
export function addSite(data) {
  return request({
    url: '/system/site',
    method: 'post',
    data: data
  })
}

// 修改垃圾站点管理
export function updateSite(data) {
  return request({
    url: '/system/site',
    method: 'put',
    data: data
  })
}

// 删除垃圾站点管理
export function delSite(id) {
  return request({
    url: '/system/site/' + id,
    method: 'delete'
  })
}
