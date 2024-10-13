import request from '@/utils/request'

// 查询垃圾分类管理列表
export function listSorting(query) {
  return request({
    url: '/system/sorting/list',
    method: 'get',
    params: query
  })
}

// 查询垃圾分类管理详细
export function getSorting(id) {
  return request({
    url: '/system/sorting/' + id,
    method: 'get'
  })
}

// 新增垃圾分类管理
export function addSorting(data) {
  return request({
    url: '/system/sorting',
    method: 'post',
    data: data
  })
}

// 修改垃圾分类管理
export function updateSorting(data) {
  return request({
    url: '/system/sorting',
    method: 'put',
    data: data
  })
}

// 删除垃圾分类管理
export function delSorting(id) {
  return request({
    url: '/system/sorting/' + id,
    method: 'delete'
  })
}
