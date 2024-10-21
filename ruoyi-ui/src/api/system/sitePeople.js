import request from '@/utils/request'

// 查询垃圾站点人员列表
export function listSitePeople(query) {
  return request({
    url: '/system/sitePeople/list',
    method: 'get',
    params: query
  })
}

// 查询垃圾站点人员详细
export function getSitePeople(id) {
  return request({
    url: '/system/sitePeople/' + id,
    method: 'get'
  })
}

// 新增垃圾站点人员
export function addSitePeople(data) {
  return request({
    url: '/system/sitePeople',
    method: 'post',
    data: data
  })
}

// 修改垃圾站点人员
export function updateSitePeople(data) {
  return request({
    url: '/system/sitePeople',
    method: 'put',
    data: data
  })
}

// 删除垃圾站点人员
export function delSitePeople(id) {
  return request({
    url: '/system/sitePeople/' + id,
    method: 'delete'
  })
}
